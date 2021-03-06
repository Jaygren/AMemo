package com.szemingcheng.amemo.presenter.Imp;

import com.szemingcheng.amemo.entity.Memo;
import com.szemingcheng.amemo.model.Imp.MemoDetailModelImp;
import com.szemingcheng.amemo.model.MemoDetailModel;
import com.szemingcheng.amemo.presenter.MemoDetailActivityPresent;
import com.szemingcheng.amemo.view.MemoDetailActivityView;

/**
 * Created by szemingcheng on 2017/5/23.
 */

public class MemoDetailActivityPresentImp implements MemoDetailActivityPresent {
    private MemoDetailModel memoDetailModel;
    private MemoDetailActivityView memoDetailActivityView;


    public MemoDetailActivityPresentImp(MemoDetailActivityView memoDetailActivityView) {
        this.memoDetailActivityView = memoDetailActivityView;
        this.memoDetailModel = new MemoDetailModelImp();
    }

    @Override
    public void load_memo_detail(Long memo_id) {
        memoDetailModel.get_memo_detail(memo_id,onDataFinishedListener);
    }

    @Override
    public void save_memo_detail(Memo memo) {
        memoDetailModel.save_memo(memo,onRequestListener);
    }

    @Override
    public void update_memo_detail(Memo memo) {
        memoDetailModel.update_memo(memo,onRequestListener);
    }

    @Override
    public void delete_memo(Long memo_id) {
        memoDetailModel.delete_memo(memo_id,onRequestListener);
    }

    @Override
    public void restore_memo(Long memo_id) {
        memoDetailModel.memo_restore(memo_id,onRequestListener);
    }

    @Override
    public void remove_memo(Long memo_id) {
        memoDetailModel.memo_remove(memo_id,onRequestListener);
    }

    private MemoDetailModel.OnDataFinishedListener onDataFinishedListener = new MemoDetailModel.OnDataFinishedListener() {
        @Override
        public void getDataFinish(Memo memo) {
            memoDetailActivityView.initViewOnViewMode(memo);
        }
        @Override
        public void onError(String error) {

        }
    };

    private MemoDetailModel.OnRequestListener onRequestListener = new MemoDetailModel.OnRequestListener() {
        @Override
        public void onSuccess() {
            memoDetailActivityView.showSaveMemoSuccess();
        }
        @Override
        public void onError(String error) {
            memoDetailActivityView.showSaveMemoFail(error);
        }

        @Override
        public void onDeleteSuccess() {
            memoDetailActivityView.showDeleteSuccess();
        }

        @Override
        public void onRestoreSuccess() {
            memoDetailActivityView.showRestoreSuccess();
        }
    };

}
