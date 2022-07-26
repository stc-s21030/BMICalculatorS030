package jp.suntech.s21030.bmicalculators030;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;

public class ConfirmDialogWarning extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstaceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.dialog_btn,new DialogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;
    }
    private class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    break;
            }
        }
    }
}
