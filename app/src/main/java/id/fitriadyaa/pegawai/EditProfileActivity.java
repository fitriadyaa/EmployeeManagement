package id.fitriadyaa.pegawai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity {
    EditText editName, editEmail, editUsername, editPassword;
    Button saveButton;
    String usernameUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        reference = FirebaseDatabase.getInstance().getReference("users");

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        saveButton = findViewById(R.id.saveButton);

        showData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDataChanged()) {
                    Toast.makeText(EditProfileActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    navigateToProfileFragment();
                } else {
                    Toast.makeText(EditProfileActivity.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                    finish(); // Finish the EditProfileActivity if no changes are found
                }
            }
        });
    }

    private void navigateToProfileFragment() {
        Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
        intent.putExtra("navigateToProfile", true); // Add an extra flag to indicate navigating to ProfileFragment
        startActivity(intent);
        finish(); // Finish the EditProfileActivity
    }

    public boolean isDataChanged() {
        String name = editName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (!name.equals(getIntent().getStringExtra("name"))) {
            reference.child(usernameUser).child("name").setValue(name);
            return true;
        } else if (!email.equals(getIntent().getStringExtra("email"))) {
            reference.child(usernameUser).child("email").setValue(email);
            return true;
        } else if (!password.equals(getIntent().getStringExtra("password"))) {
            reference.child(usernameUser).child("password").setValue(password);
            return true;
        } else {
            return false;
        }
    }

    public void showData() {
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        String passwordUser = intent.getStringExtra("password");

        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editUsername.setText(usernameUser);
        editPassword.setText(passwordUser);
    }
}