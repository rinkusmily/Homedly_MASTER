package com.gunaeats.myecommerce.FragmentUtills;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.UserSession;
import com.gunaeats.myecommerce.model.categorymodel.userlist.UserLst;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.disposables.Disposable;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment  extends Fragment {
    View view;
    private static final String ARG_PARAM = "param";
    // Help remove to cart
    // cart order -- total order and 200 side me
    // order summery tersms remove and shedule date time contact detail cheek out
    // name address mobile pincoe landmark
    // my orders -- all aur confirm
    // order details comment




    public static ProfileFragment newInstance(String param) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }
    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    CircleImageView ProfileImage;
    TextInputEditText edtFirstName;
    TextInputEditText edtLastName;
    TextInputEditText edtEmail;
    TextInputEditText edtMobile;
    TextInputEditText edtAddress;
    Button updateProfile;

    Context mContext;

    private String cameraImagePath = null;
    private static final int REQUEST_TAKE_PHOTO = 113;
    File imageFile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        mContext = getActivity();
        ProfileImage = view.findViewById(R.id.profile_image);
        edtFirstName = view.findViewById(R.id.tv_fiest_name);
        edtLastName = view.findViewById(R.id.tv_last_name);
        edtEmail = view.findViewById(R.id.tv_email);
        edtMobile = view.findViewById(R.id.tv_amobile);
        edtAddress = view.findViewById(R.id.tv_address);
        updateProfile = view.findViewById(R.id.id_updateprofile);


        getProfile();

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strfname = edtFirstName.getText().toString();
                String strlastNmae = edtLastName.getText().toString();
                String stremail = edtEmail.getText().toString();
                String seraddress = edtAddress.getText().toString();

                if (!validation()){
                    return;
                }
                Map<String,Object> params = new HashMap<>();
                params.put("action","UpdateProfile");
                params.put("user_id", UserSession.getInstance(getActivity()).readPrefs(UserSession.PREFS_USER_ID));
                params.put("userfname",""+strfname);
                params.put("userlname",""+strlastNmae);
                params.put("address",""+seraddress);



                updateProfile(params);
            }
        });

        ProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // selectImage();

                dispatchTakePictureIntent();
            }
        });
    return view;
    }


    boolean  validation(){
        boolean valid= true;
        String strfname = edtFirstName.getText().toString();
        String strlastNmae = edtLastName.getText().toString();
        String stremail = edtEmail.getText().toString();
        String seraddress = edtAddress.getText().toString();
        if (strfname.isEmpty()){
            edtFirstName.setError("Enter First Name");
            valid = false;
        }else {
            edtFirstName.setError(null);
        }
        if (strlastNmae.isEmpty()){
            edtLastName.setError("Enter Last Name");
            valid = false;
        }else {
            edtLastName.setError(null);
        }

        /*if (!Patterns.EMAIL_ADDRESS.matcher(stremail).matches()){
            edtEmail.setError("Enter Email");
            valid = false;
        }else {
            edtEmail.setError(null);
        }*/
        if (seraddress.isEmpty()){
            edtAddress.setError("Enter Address");
            valid = false;
        }else {
            edtAddress.setError(null);
        }

        return valid;

    }
    void getProfile(){
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(" Please Wait...");
        progressDialog.show();

        OkHttpRequest httpRequest = new OkHttpRequest(getActivity());
        Map<String,Object> params = new HashMap<>();
        params.put("action","Profile");
        params.put("userId",UserSession.getInstance(getActivity()).readPrefs(UserSession.PREFS_USER_ID));
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                progressDialog.dismiss();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                UserLst userLst = gson.fromJson(result,UserLst.class);
                if (userLst.getStatus()==1){

                    if (userLst.getResponse().getUserFname()==null||userLst.getResponse().getUserFname().equals("null")||userLst.getResponse().getUserFname().equals("")){

                    }else {
                        edtFirstName.setText(""+userLst.getResponse().getUserFname());
                    }

                    if (userLst.getResponse().getUserLname()==null||userLst.getResponse().getUserLname().equals("null")||userLst.getResponse().getUserLname().equals("")){

                    }else {
                        edtLastName.setText(""+userLst.getResponse().getUserLname());
                    }


                    edtEmail.setText(""+userLst.getResponse().getEmail());
                    edtMobile.setText(""+userLst.getResponse().getMobile());

                    if (userLst.getResponse().getAddress()==null||userLst.getResponse().getAddress().equals("null")||userLst.getResponse().getAddress().equals("")){

                    }else {
                        edtAddress.setText(""+userLst.getResponse().getAddress());
                    }



                    String profilrimge = userLst.getResponse().getBaseurl()+""+userLst.getResponse().getAvatar();

                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.no_image);
                    requestOptions.error(R.drawable.no_image);

                    Log.e("USERIMAGEDATA",">>> "+profilrimge);
                    Glide.with(mContext)
                            .setDefaultRequestOptions(requestOptions)
                            .load(profilrimge).into(ProfileImage);

                }
            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
            }
        });

    }

    void  updateProfile(Map<String,Object> params){
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Profile Updating Please Wait");
        progressDialog.show();
        OkHttpRequest httpRequest = new OkHttpRequest(getActivity());

        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                progressDialog.dismiss();
                Toast.makeText(mContext, "Update Profile Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
            progressDialog.dismiss();
            }
        });

    }



    private void selectImage() {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
  /*  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    ProfileImage.setImageBitmap(bitmap);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = mContext.getContentResolver().query(selectedImage,filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("path of image frory....", picturePath+"");
                ProfileImage.setImageBitmap(thumbnail);
            }
        }
    }
*/
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Create the File where the photo should go
            File newFile = null;
            try {
                newFile = createImageFile();
                cameraImagePath = newFile.getAbsolutePath();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    cameraImagePath = newFile.getAbsolutePath();
                    takePictureIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    Uri photoURI = FileProvider.getUriForFile(getActivity(), "com.gunaeats.myecommerce.fileprovider", newFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                } else {
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
                }
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(getActivity(), "No Camera Exist", Toast.LENGTH_SHORT).show();
        }
    }
    private File createImageFile() throws IOException {
        // Create an image file name
        String imageFileName = "JPEG_" + System.currentTimeMillis() + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        if (!storageDir.exists()) {
            if (!storageDir.mkdir()) {
                throw new IOException();
            }
        }
        return new File(storageDir, imageFileName);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case REQUEST_TAKE_PHOTO:
                if (resultCode == Activity.RESULT_OK && cameraImagePath != null && !TextUtils.isEmpty(cameraImagePath)) {
                    imageFile = new File(cameraImagePath);
                    Log.e("CAMERAIMAGEE",">>> "+imageFile);
                    ProfileImage.setImageURI(Uri.parse(imageFile.getAbsolutePath()));

                    HashMap<String,Object> params = new HashMap<>();
                    params.put("action","UpdateProfileImage");
                    params.put("image",imageFile);
                    params.put("user_id",UserSession.getInstance(getActivity()).readPrefs(UserSession.PREFS_USER_ID));
                    updateImage(params);
                }
                break;
        }

    }


    void  updateImage(Map<String,Object> params){

        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Image Updating Please Wait");
        progressDialog.show();
        OkHttpRequest httpRequest = new OkHttpRequest(getActivity());

        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                Toast.makeText(mContext, "Update Profile Success", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
            }
        });

    }


}
