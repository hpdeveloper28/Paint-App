package com.mydrawingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mydrawingapp.paint.PaintConstants;
import com.mydrawingapp.paint.PaintView;
import com.mydrawingapp.paint.interfaces.PaintViewCallBack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private PaintView mPaintView;
    private Button btnPencil, btnErasor, btnUndo, btnRedo, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPaintView = (PaintView) findViewById(R.id.paintView);
//        mPaintView.setBackgroundResource(R.drawable.z);

        btnPencil = (Button) findViewById(R.id.btnPencil);
        btnErasor = (Button) findViewById(R.id.btnErasor);
        btnUndo = (Button) findViewById(R.id.btnUndo);
        btnRedo = (Button) findViewById(R.id.btnRedo);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnPencil.setOnClickListener(this);
        btnErasor.setOnClickListener(this);
        btnUndo.setOnClickListener(this);
        btnRedo.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        initCallBack();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPencil:
                onClickButtonPencil();
                break;
            case R.id.btnErasor:
                onClickButtonEraser();
                break;
            case R.id.btnUndo:
                onClickButtonUndo();
                break;
            case R.id.btnRedo:
                onClickButtonRedo();
                break;
            case R.id.btnClear:
                mPaintView.clearAll(false);
                break;
        }
    }

    private void onClickButtonPencil() {
        mPaintView.setCurrentPainterType(PaintConstants.PEN_TYPE.PLAIN_PEN);
    }

    private void onClickButtonEraser() {
        mPaintView.setCurrentPainterType(PaintConstants.PEN_TYPE.ERASER);
    }

    private void onClickButtonRedo() {
        mPaintView.redo();
        upDateUndoRedo();
    }

    /**
     * undo
     */
    private void onClickButtonUndo() {
        mPaintView.undo();
        upDateUndoRedo();
    }

    private void upDateUndoRedo() {
        if (mPaintView.canUndo()) {
            enableUndoButton();
        } else {
            disableUndoButton();
        }
        if (mPaintView.canRedo()) {
            enableRedoButton();
        } else {
            disableRedoButton();
        }
    }

    private void initCallBack() {
        mPaintView.setCallBack(new PaintViewCallBack() {
            // 当画了之后对Button进行更新
            @Override
            public void onHasDraw() {
                enableUndoButton();
                disableRedoButton();
            }

            // 当点击之后让各个弹出的窗口都消失
            @Override
            public void onTouchDown() {
            }
        });
    }

    private void disableRedoButton() {

    }

    private void enableRedoButton() {
        
    }

    private void disableUndoButton() {
        
    }

    private void enableUndoButton() {
    }
}
