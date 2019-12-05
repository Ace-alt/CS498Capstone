package com.example.andriod.yeswecodeproject;

import android.content.ClipData;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int a,b,c,d,e,f,g;
    RelativeLayout space1,space2,space3,space4,space5,space6,space7,space8;
    Button dragA,dragB,dragC,dragD,dragE,dragF,dragG;
    Button drag1,drag2,drag3,drag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        //Buttons
        //Back to Game Selection Button
        Button back = (Button) findViewById(R.id.backtogameSelectButton2);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });

        //Clear
        final Button clear = (Button) findViewById(R.id.clearButton);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clearIntent = getIntent();
                finish();
                startActivity(clearIntent);

            }
        });

        TextView musicHelp = (TextView) findViewById(R.id.musicbox);
        musicHelp.setText(R.string.musichelp);

        //Buttons for Dragging with Listeners
        dragA = (Button) findViewById(R.id.noteA);
        dragB = (Button) findViewById(R.id.noteB);
        dragC = (Button) findViewById(R.id.noteC);
        dragD = (Button) findViewById(R.id.noteD);
        dragE = (Button) findViewById(R.id.noteE);
        dragF = (Button) findViewById(R.id.noteF);
        dragG = (Button) findViewById(R.id.noteG);

        drag1 = (Button) findViewById(R.id.beat1);
        drag2 = (Button) findViewById(R.id.beat2);
        drag3 = (Button) findViewById(R.id.beat3);
        drag4 = (Button) findViewById(R.id.beat4);

        dragA.setOnLongClickListener(longClickListener);
        dragB.setOnLongClickListener(longClickListener);
        dragC.setOnLongClickListener(longClickListener);
        dragD.setOnLongClickListener(longClickListener);
        dragE.setOnLongClickListener(longClickListener);
        dragF.setOnLongClickListener(longClickListener);
        dragG.setOnLongClickListener(longClickListener);

        drag1.setOnLongClickListener(longClickListener);
        drag2.setOnLongClickListener(longClickListener);
        drag3.setOnLongClickListener(longClickListener);
        drag4.setOnLongClickListener(longClickListener);


        //Spaces for Dropping
        space1 = (RelativeLayout) findViewById(R.id.space1);
        space2 = (RelativeLayout) findViewById(R.id.space2);
        space3 = (RelativeLayout) findViewById(R.id.space3);
        space4 = (RelativeLayout) findViewById(R.id.space4);
        space5 = (RelativeLayout) findViewById(R.id.space5);
        space6 = (RelativeLayout) findViewById(R.id.space6);
        space7 = (RelativeLayout) findViewById(R.id.space7);
        space8 = (RelativeLayout) findViewById(R.id.space8);

        space1.setOnDragListener(dragListener);
        space2.setOnDragListener(dragListener);
        space3.setOnDragListener(dragListener);
        space4.setOnDragListener(dragListener);
        space5.setOnDragListener(dragListener);
        space6.setOnDragListener(dragListener);
        space7.setOnDragListener(dragListener);
        space8.setOnDragListener(dragListener);

        //Testing soundPool
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(7)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        }

        a = soundPool.load(this, R.raw.a, 1);
        b = soundPool.load(this, R.raw.b, 1);
        c = soundPool.load(this, R.raw.c, 1);
        d = soundPool.load(this, R.raw.d, 1);
        e = soundPool.load(this, R.raw.e, 1);
        f = soundPool.load(this, R.raw.f, 1);
        g = soundPool.load(this, R.raw.g, 1);
    }


    //Dragging Methods
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
            //use outdate version? view.startDrag
            view.startDragAndDrop(data,myShadowBuilder,view,0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            final View viewCopy = (View) event.getLocalState();

            TextView musicbox = (TextView) findViewById(R.id.musicbox);

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED: break;

                case DragEvent.ACTION_DRAG_EXITED: break;

                case DragEvent.ACTION_DROP:

                    //Notes A-G for Spaces 1-4
                    if(((view.getId()==R.id.noteA) || (view.getId()==R.id.noteB)||(view.getId()==R.id.noteC)
                            ||(view.getId()==R.id.noteD)||(view.getId()==R.id.noteE)||(view.getId()==R.id.noteF)||
                            (view.getId()==R.id.noteG))
                            && v.getId()==R.id.space1){
                        RelativeLayout noteView = (RelativeLayout) view.getParent();
                        RelativeLayout spaceView = (RelativeLayout) v;
                        noteView.removeView(view);
                        spaceView.addView(view);
                    }
                    else if(((view.getId()==R.id.noteA) || (view.getId()==R.id.noteB)||(view.getId()==R.id.noteC)
                            ||(view.getId()==R.id.noteD)||(view.getId()==R.id.noteE)||(view.getId()==R.id.noteF)||
                            (view.getId()==R.id.noteG))
                            && v.getId()==R.id.space2){
                        RelativeLayout oldView = (RelativeLayout) view.getParent();
                        oldView.removeView(view);
                        RelativeLayout newView = (RelativeLayout) v;
                        newView.addView(view);
                    }

                    else if(((view.getId()==R.id.noteA) || (view.getId()==R.id.noteB)||(view.getId()==R.id.noteC)
                            ||(view.getId()==R.id.noteD)||(view.getId()==R.id.noteE)||(view.getId()==R.id.noteF)||
                            (view.getId()==R.id.noteG))
                            && v.getId()==R.id.space3){
                        RelativeLayout oldView = (RelativeLayout) view.getParent();
                        oldView.removeView(view);
                        RelativeLayout newView = (RelativeLayout) v;
                        newView.addView(view);
                    }

                    else if(((view.getId()==R.id.noteA) || (view.getId()==R.id.noteB)||(view.getId()==R.id.noteC)
                            ||(view.getId()==R.id.noteD)||(view.getId()==R.id.noteE)||(view.getId()==R.id.noteF)||
                            (view.getId()==R.id.noteG))
                            && v.getId()==R.id.space4){
                        RelativeLayout oldView = (RelativeLayout) view.getParent();
                        oldView.removeView(view);
                        RelativeLayout newView = (RelativeLayout) v;
                        newView.addView(view);
                    }

                    //Beats 1-4 for spaces 5-8
                    else if(((view.getId()==R.id.beat1) || (view.getId()==R.id.beat2)
                            ||(view.getId()==R.id.beat3)||(view.getId()==R.id.beat4))
                            && v.getId()==R.id.space5){
                        RelativeLayout oldView = (RelativeLayout) view.getParent();
                        oldView.removeView(view);
                        RelativeLayout newView = (RelativeLayout) v;
                        newView.addView(view);
                    }
                    else if(((view.getId()==R.id.beat1) || (view.getId()==R.id.beat2)
                            ||(view.getId()==R.id.beat3)||(view.getId()==R.id.beat4))
                            && v.getId()==R.id.space6){
                        RelativeLayout oldView = (RelativeLayout) view.getParent();
                        oldView.removeView(view);
                        RelativeLayout newView = (RelativeLayout) v;
                        newView.addView(view);
                    }
                    else if(((view.getId()==R.id.beat1) || (view.getId()==R.id.beat2)
                            ||(view.getId()==R.id.beat3)||(view.getId()==R.id.beat4))
                            && v.getId()==R.id.space7){
                        RelativeLayout oldView = (RelativeLayout) view.getParent();
                        oldView.removeView(view);
                        RelativeLayout newView = (RelativeLayout) v;
                        newView.addView(view);
                    }
                    else if(((view.getId()==R.id.beat1) || (view.getId()==R.id.beat2)
                            ||(view.getId()==R.id.beat3)||(view.getId()==R.id.beat4))
                            && v.getId()==R.id.space8){
                        RelativeLayout oldView = (RelativeLayout) view.getParent();
                        oldView.removeView(view);
                        RelativeLayout newView = (RelativeLayout) v;
                        newView.addView(view);
                    }
                    break;


            }
            return true;
        }
    };


    //method to play sounds
    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.noteA:
                soundPool.play(a, 1, 1, 0, 0, 1);
                break;
            case R.id.noteB:
                soundPool.play(b, 1, 1, 0, 0, 1);
                break;
            case R.id.noteC:
                soundPool.play(c, 1, 1, 0, 0, 1);
                break;
            case R.id.noteD:
                soundPool.play(d, 1, 1, 0, 0, 1);
                break;
            case R.id.noteE:
                soundPool.play(e, 1, 1, 0, 0, 1);
                break;
            case R.id.noteF:
                soundPool.play(f, 1, 1, 0, 0, 1);
                break;

            case R.id.noteG:
                soundPool.play(g, 1, 1, 0, 0, 1);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

    //plays sounds within the spaces in correct order
    public void playList(View v){
        int groupDelay2=0;
        int groupDelay3=0;
        int groupDelay4=0;

            //finds what beat is in the view
            int group1Num = 0;
            if (space5.findViewById(R.id.beat1) != null) {
                group1Num = 1;
                groupDelay2 = 2000;
            } else if (space5.findViewById(R.id.beat2) != null) {
                group1Num = 2;
                groupDelay2 = 3000;
            } else if (space5.findViewById(R.id.beat3) != null) {
                group1Num = 3;
                groupDelay2 = 4000;
            } else if (space5.findViewById(R.id.beat4) != null) {
                group1Num = 4;
                groupDelay2 = 5000;
            }

        //space6/group2Num
        int group2Num = 0;
        if (space6.findViewById(R.id.beat1) != null) {
            group2Num = 1;
            groupDelay3 = groupDelay2+ 2000;
        } else if (space6.findViewById(R.id.beat2) != null) {
            group2Num = 2;
            groupDelay3 = groupDelay2+3000;
        } else if (space6.findViewById(R.id.beat3) != null) {
            group2Num = 3;
            groupDelay3 = groupDelay2+4000;
        } else if (space6.findViewById(R.id.beat4) != null) {
            group2Num = 4;
            groupDelay3 = groupDelay2+5000;
        }

        final int finalBeat2 = group2Num;

        int group3Num = 0;
        if (space7.findViewById(R.id.beat1) != null) {
            group3Num = 1;
            groupDelay4 = groupDelay3+2000;
        } else if (space7.findViewById(R.id.beat2) != null) {
            group3Num = 2;
            groupDelay4 = groupDelay3+3000;
        } else if (space7.findViewById(R.id.beat3) != null) {
            group3Num = 3;
            groupDelay4 = groupDelay3+4000;
        } else if (space7.findViewById(R.id.beat4) != null) {
            group3Num = 4;
            groupDelay4 = groupDelay3+5000;
        }

        final int finalBeat3 = group3Num;

        int group4Num = 0;
        if (space8.findViewById(R.id.beat1) != null) {
            group4Num = 1;
        } else if (space8.findViewById(R.id.beat2) != null) {
            group4Num = 2;
        } else if (space8.findViewById(R.id.beat3) != null) {
            group4Num = 3;
        } else if (space8.findViewById(R.id.beat4) != null) {
            group4Num = 4;
        }
        final int finalBeat4 = group4Num;


            //finds what note is in view and plays it ___ times
            if ((space1.getChildCount() != 0) && (space5.getChildCount() != 0)) {
                if (space1.findViewById(R.id.noteA) != null) {
                    //Have to set an delay so that user can hear the separate beats
                    int delayTime = 1000;
                    for (int i = 0; i < group1Num; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragA.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space1.findViewById(R.id.noteB) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < group1Num; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragB.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space1.findViewById(R.id.noteC) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < group1Num; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragC.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space1.findViewById(R.id.noteD) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < group1Num; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragD.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space1.findViewById(R.id.noteE) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < group1Num; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragE.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space1.findViewById(R.id.noteF) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < group1Num; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragF.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space1.findViewById(R.id.noteG) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < group1Num; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragG.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                }
            }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            if ((space2.getChildCount() != 0) && (space6.getChildCount() != 0)) {
                if (space2.findViewById(R.id.noteA) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat2; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragA.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space2.findViewById(R.id.noteB) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat2; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragB.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space2.findViewById(R.id.noteC) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat2; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragC.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space2.findViewById(R.id.noteD) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat2; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragD.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space2.findViewById(R.id.noteE) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat2; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragE.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space2.findViewById(R.id.noteF) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat2; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragF.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space2.findViewById(R.id.noteG) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat2; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragG.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                }
            }
            }
        }, groupDelay2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            if ((space3.getChildCount() != 0) && (space7.getChildCount() != 0)) {
                if (space3.findViewById(R.id.noteA) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat3; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragA.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space3.findViewById(R.id.noteB) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat3; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragB.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space3.findViewById(R.id.noteC) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat3; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragC.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space3.findViewById(R.id.noteD) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat3; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragD.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space3.findViewById(R.id.noteE) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat3; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragE.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space3.findViewById(R.id.noteF) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat3; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragF.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space3.findViewById(R.id.noteG) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat3; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragG.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                }
            }
            }
        }, groupDelay3);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            if ((space4.getChildCount() != 0) && (space8.getChildCount() != 0)) {
                if (space4.findViewById(R.id.noteA) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat4; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragA.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space4.findViewById(R.id.noteB) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat4; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragB.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space4.findViewById(R.id.noteC) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat4; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragC.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space4.findViewById(R.id.noteD) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat4; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragD.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space4.findViewById(R.id.noteE) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat4; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragE.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space4.findViewById(R.id.noteF) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat4; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragF.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                } else if (space4.findViewById(R.id.noteG) != null) {
                    int delayTime = 1000;
                    for (int i = 0; i < finalBeat4; i++) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dragG.performClick();
                            }
                        }, delayTime);
                        delayTime = delayTime + 1000;
                    }
                }
            }
            }
        }, groupDelay4);


    }

    }
