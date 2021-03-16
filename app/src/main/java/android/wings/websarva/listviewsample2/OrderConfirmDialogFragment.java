package android.wings.websarva.listviewsample2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class OrderConfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState) {
        //ダイアログビルダー
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);

        //PositiveButton
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        //NegativeButton
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        //NeutralButton
        builder.setNeutralButton(R.string.dialog_btn_nu, new DialogButtonClickListener());

        //builderをもとにダイアログオブジェクトを生成、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }


    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //トーストメッセージ用
            String msg = "";
            //タップさせたボタンにより分岐処理
            switch(which){
                //PositiveButton
                case DialogInterface.BUTTON_POSITIVE:
                    msg = getString(R.string.dialog_ok_toast);
                    break;
                //NegativeButton
                case DialogInterface.BUTTON_NEGATIVE:
                    msg = getString(R.string.dialog_ng_toast);
                    break;
                //NeutralButton
                case DialogInterface.BUTTON_NEUTRAL:
                    msg = getString(R.string.dialog_nu_toast);
                    break;
            }

            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();

        }
    }

}
