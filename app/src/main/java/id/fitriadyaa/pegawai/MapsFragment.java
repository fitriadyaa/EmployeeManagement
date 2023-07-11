package id.fitriadyaa.pegawai;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MapsFragment extends Fragment {
    private EditText sourceEdt, destinationEdt;
    private Button directionBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        sourceEdt = view.findViewById(R.id.idEdtSourceLocation);
        destinationEdt = view.findViewById(R.id.idEdtDestinationLocation);
        directionBtn = view.findViewById(R.id.idBtnShowDirection);

        directionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sourceEdt.getText().toString().isEmpty() && destinationEdt.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter source and destination location..", Toast.LENGTH_SHORT).show();
                } else {
                    openMapsIntent(sourceEdt.getText().toString(), destinationEdt.getText().toString());
                }
            }
        });

        return view;
    }

    private void openMapsIntent(String source, String destination) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + source + "/" + destination);
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            i.setPackage("com.google.android.apps.maps");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
    }
}