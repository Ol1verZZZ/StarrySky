package com.other.finalproject.utils;

import android.content.Context;
import android.view.View;

import com.other.finalproject.R;


public class ShowDialogManager {

	private static ShowDialogManager showDialogManager;
	private CustomDialog dialog;
	private CustomDialog customDialog;

	public interface AddOnClikLister {
		void setOnclickLister(View view);
	}
	public interface DoubleOnClikLister {
		void setOnCancel(View view);
		void setOnConfirm(View view);
	}

	private ShowDialogManager() {
	}

	public static ShowDialogManager getInstance() {
		if (showDialogManager == null) {
			synchronized (ShowDialogManager.class) {
				if (showDialogManager == null) {
					showDialogManager = new ShowDialogManager();
				}
			}
		}
		return showDialogManager;
	}

	/**
	 * 确认删除的提示框
	 *
	 * @param context
	 * @param tv
	 * @param listener
	 */
	public void showDialogHint(Context context, String tv, AddOnClikLister listener) {
		CustomDialog.Builder builder = new CustomDialog.Builder(context);
		dialog = builder
				.style(R.style.DialogOne)
				.heightdp(180)
				.widthdp(280)
				.cancelTouchout(false)
				.view(R.layout.item_dialog_hint)
				.addText(R.id.tv_content, tv)

				.addViewOnclick(R.id.tv_cancel_dialog, v -> {
					if (dialog != null && dialog.isShowing()) {
						dialog.dismiss();
					}
				})
				.addViewOnclick(R.id.tv_sure_del, v -> {
					if (dialog != null && dialog.isShowing()) {
						dialog.dismiss();
					}
					if (listener != null) {
						listener.setOnclickLister(v);
					}
				})
				.build();
		dialog.show();
	}

}
