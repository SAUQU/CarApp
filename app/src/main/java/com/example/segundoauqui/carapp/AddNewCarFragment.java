package com.example.admin.carfragmentapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.segundoauqui.carapp.Car;
import com.example.segundoauqui.carapp.CarRecyclerViewFragment;
import com.example.segundoauqui.carapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AddNewCarFragment extends Fragment {


    Car car;
    @BindView(R.id.etModel)
    EditText etModel;
    @BindView(R.id.etType)
    EditText etType;
    @BindView(R.id.etYear)
    EditText etYear;
    @BindView(R.id.btnSaveCar)
    Button btnSaveCar;
    Unbinder unbinder;

    private OnFragmentInteractionListener mListener;

    public AddNewCarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_car, container, false);
        unbinder = ButterKnife.bind(this, view);
        return inflater.inflate(...);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSaveCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car = new Car(etModel.getText().toString().trim(), etType.getText().toString().trim(),
                        etYear.getText().toString().trim());
                DatabaseHelper db = new DatabaseHelper(v.getContext());
                db.saveNewContact(car);
                etModel.setText("Model: ");
                etType.setText("Type: ");
                etYear.setText("Year: ");

                CarRecyclerViewFragment carListView = new CarRecyclerViewFragment();
                getFragmentManager().beginTransaction().replace(R.id.flFrag2, carListView, "addCar").commit();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Car car);
    }
}
