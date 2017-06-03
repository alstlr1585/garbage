package com.example.sinmingu.brailleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;

import java.util.ArrayList;
import java.util.Random;

// 문제 수 변경 시, problemCount 변수 값 수정할 것!

public class word_quiz extends BaseActivity {

    ImageView quiz_word_problem;
    Random random;
    int problem_now;
    ArrayList<Integer> problemHistory, checkFlag, userSolutionHistory;
    int solution, problemCount = 30;
    CheckBox quiz_word_checkbox1, quiz_word_checkbox2, quiz_word_checkbox3, quiz_word_checkbox4;
    TextView quiz_word_choice_1, quiz_word_choice_2, quiz_word_choice_3, quiz_word_choice_4, quiz_word_solution, quiz_word_commentary, quiz_word_rightAnswer, quiz_word_wrongAnswer, quiz_word_problem_number;
    Button quiz_word_next, quiz_word_before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_quiz);

        // 랜덤 돌리기용
        random = new Random();


        // 지나온 문제 남기기 위한 배열과 현재가 몇번문제인지 알기위한 int 변수
        problemHistory = new ArrayList<Integer>();
        problem_now = 0;

        // 맞은 문제, 틀린 문제 세탁 방지용
        checkFlag = new ArrayList<Integer>();

        // 과거 답안 저장용
        userSolutionHistory = new ArrayList<Integer>();

        // 문제
        quiz_word_problem = (ImageView)findViewById(R.id.quiz_word_problem);

        // 1~4번 체크박스
        quiz_word_checkbox1 = (CheckBox)findViewById(R.id.quiz_word_checkbox1);
        quiz_word_checkbox2 = (CheckBox)findViewById(R.id.quiz_word_checkbox2);
        quiz_word_checkbox3 = (CheckBox)findViewById(R.id.quiz_word_checkbox3);
        quiz_word_checkbox4 = (CheckBox)findViewById(R.id.quiz_word_checkbox4);

        // 보기
        quiz_word_choice_1 = (TextView)findViewById(R.id.quiz_word_choice_1);
        quiz_word_choice_2 = (TextView)findViewById(R.id.quiz_word_choice_2);
        quiz_word_choice_3 = (TextView)findViewById(R.id.quiz_word_choice_3);
        quiz_word_choice_4 = (TextView)findViewById(R.id.quiz_word_choice_4);

        // 가장 위에 [x번 문제] 표시하는 텍스트 뷰
        quiz_word_problem_number = (TextView)findViewById(R.id.quiz_word_problem_number);

        // 정답
        quiz_word_solution = (TextView)findViewById(R.id.quiz_word_solution);

        // 해설
        quiz_word_commentary = (TextView)findViewById(R.id.quiz_word_commentary);

        // 맞은 개수
        quiz_word_rightAnswer = (TextView)findViewById(R.id.quiz_word_rightAnswer);

        // 틀린 개수
        quiz_word_wrongAnswer = (TextView)findViewById(R.id.quiz_word_wrongAnswer);

        // 다음 버튼
        quiz_word_next = (Button)findViewById(R.id.quiz_word_next);

        // 이전 버튼
        quiz_word_before = (Button)findViewById(R.id.quiz_word_before);

        // Glide.with(this).load(R.drawable.quiz_word).into(quiz_word_problem);

        quiz_word_solution.setVisibility(View.INVISIBLE);   // 초기엔 투명화
        quiz_word_commentary.setVisibility(View.INVISIBLE);

        onNextClick(quiz_word_next);   // 처음에 켜면 자동으로 문제 하나 출제

    }

    public void onBeforeClick(View v){  // 이전 버튼 클릭 시

        if (problem_now == 1) {
            Toast.makeText(this, "맨 첫 문제입니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            setProblem(problemHistory.get((--problem_now)-1));
            if (checkFlag.get((problem_now) - 1) == 0) {    // 안 풀고 간거라면
                quiz_word_solution.setVisibility(View.INVISIBLE);
                quiz_word_commentary.setVisibility(View.INVISIBLE);
                setCheckable(true);
            }
            else{   // 풀고 간거라면
                quiz_word_solution.setVisibility(View.VISIBLE);
                quiz_word_commentary.setVisibility(View.VISIBLE);
                setBeforeChecked(userSolutionHistory.get((problem_now) - 1));
            }

        }
    }

    public void onNextClick(View v){    // 다음 버튼 클릭 시
        int problemNumber = random.nextInt(problemCount);
        if (problemHistory.size() == problem_now) { // 새로운 문제 생성
            problem_now++;  // 문제 번호를 +1
            quiz_word_solution.setVisibility(View.INVISIBLE);
            quiz_word_commentary.setVisibility(View.INVISIBLE);
            problemHistory.add(problemNumber);  // 기록남기기
            checkFlag.add(0);
            userSolutionHistory.add(0);
            setProblem(problemNumber);
            setCheckable(true);
        }
        else {  // 지나간 문제
            setProblem(problemHistory.get((++problem_now) - 1));
            if (checkFlag.get((problem_now) - 1) == 0){     // 안풀고 넘어간거라면
                quiz_word_solution.setVisibility(View.INVISIBLE);
                quiz_word_commentary.setVisibility(View.INVISIBLE);
                setCheckable(true);
            }
            else{   // 풀고 간 거라면
                quiz_word_solution.setVisibility(View.VISIBLE);
                quiz_word_commentary.setVisibility(View.VISIBLE);
                setBeforeChecked(userSolutionHistory.get((problem_now) - 1));
            }
        }
    }

    public void onSolutionCheckClick(View v){   // 확인 버튼이 클릭되면...

        if (checkFlag.get(problem_now-1) == 1) // 같은 문제에서 한번 이상 클릭했다면? 맞은문제 틀린문제 세탁 방지용
            return;

        onSolutionCheck();

        checkFlag.set(problem_now-1, 1);
        setCheckable(false);
    }


    public void onSolutionCheck(){      // 사용자가 제출한 정답이 정답인지 체크하고, 맞거나 틀린 문제 개수를 플러스

        if (onChoiceCheck() == -1)  // 복수선택이면 함수를 실행하지 않고 종료
            return;

        quiz_word_solution.setVisibility(View.VISIBLE);     // 정답과 해설을 가시화
        quiz_word_commentary.setVisibility(View.VISIBLE);

        if (onChoiceCheck() == solution)    // 선택한 것이 정답이라면
            quiz_word_rightAnswer.setText("" + (Integer.parseInt(quiz_word_rightAnswer.getText().toString()) + 1));
        else
            quiz_word_wrongAnswer.setText("" + (Integer.parseInt(quiz_word_wrongAnswer.getText().toString()) + 1));
        userSolutionHistory.set(problem_now-1, onChoiceCheck());
    }


    public void setProblem(int problemNumber){  // 새로운 문제 출제
        onCheckRefresh();

        quiz_word_problem_number.setText("" + problem_now + "번 문제");

        switch(problemNumber){
            // 문제 설정
            case 0:
                Glide.with(this).load(R.drawable.word_problem_1).into(quiz_word_problem);
                setChoice("자동차","공유기","마음","물");     // 보기 설정
                setSolution(3, "dd");
                break;
            case 1:
                Glide.with(this).load(R.drawable.word_problem_2).into(quiz_word_problem);
                setChoice("빛","영화관","고양이","시각");     // 보기 설정
                setSolution(1, "dd");
                break;
            case 2:
                Glide.with(this).load(R.drawable.word_problem_3).into(quiz_word_problem);
                setChoice("세탁기","휴지","안경","기린");     // 보기 설정
                setSolution(3, "dd");
                break;
            case 3:
                Glide.with(this).load(R.drawable.word_problem_4).into(quiz_word_problem);
                setChoice("강아지","한국어","라디오","신문");     // 보기 설정
                setSolution(4, "dd");
                break;
            case 4:
                Glide.with(this).load(R.drawable.word_problem_5).into(quiz_word_problem);
                setChoice("어플","한국","한국어","콜라");     // 보기 설정
                setSolution(2, "dd");
                break;
            case 5:
                Glide.with(this).load(R.drawable.word_problem_6).into(quiz_word_problem);
                setChoice("지하철","너구리","운명","마우스");     // 보기 설정
                setSolution(1, "dd");
                break;
            case 6:
                Glide.with(this).load(R.drawable.word_problem_7).into(quiz_word_problem);
                setChoice("영어","엄마","점자","아버지");     // 보기 설정
                setSolution(3, "dd");
                break;
            case 7:
                Glide.with(this).load(R.drawable.word_problem_8).into(quiz_word_problem);
                setChoice("코끼리","악어","치타","호랑이");     // 보기 설정
                setSolution(4, "dd");
                break;
            case 8:
                Glide.with(this).load(R.drawable.word_problem_9).into(quiz_word_problem);
                setChoice("모니터","비디오","가습기","라디오");     // 보기 설정
                setSolution(4, "dd");
                break;
            case 9:
                Glide.with(this).load(R.drawable.word_problem_10).into(quiz_word_problem);
                setChoice("숲","흙","불","닭");     // 보기 설정
                setSolution(2, "dd");
                break;
            case 10:
                Glide.with(this).load(R.drawable.word_problem_11).into(quiz_word_problem);
                setChoice("스포츠","콜라","탄산","사이다");     // 보기 설정
                setSolution(2, "dd");
                break;
            case 11:
                Glide.with(this).load(R.drawable.word_problem_12).into(quiz_word_problem);
                setChoice("자전거","지하철","자동차","비행기");     // 보기 설정
                setSolution(3, "dd");
                break;
            case 12:
                Glide.with(this).load(R.drawable.word_problem_13).into(quiz_word_problem);
                setChoice("한글","한민족","한국사","한국어");     // 보기 설정
                setSolution(4, "dd");
                break;
            case 13:
                Glide.with(this).load(R.drawable.word_problem_14).into(quiz_word_problem);
                setChoice("카카오톡","텔레비전","페이스북","통신사");     // 보기 설정
                setSolution(1, "dd");
                break;
            case 14:
                Glide.with(this).load(R.drawable.word_problem_15).into(quiz_word_problem);
                setChoice("백화점","편의점","레스토랑","시장");     // 보기 설정
                setSolution(2, "dd");
                break;
            case 15:
                Glide.with(this).load(R.drawable.word_problem_16).into(quiz_word_problem);
                setChoice("햄버거","치킨","피자","중식");     // 보기 설정
                setSolution(2, "dd");
                break;
            case 16:
                Glide.with(this).load(R.drawable.word_problem_17).into(quiz_word_problem);
                setChoice("도박","복권","연금","로또");     // 보기 설정
                setSolution(2, "dd");
                break;
            case 17:
                Glide.with(this).load(R.drawable.word_problem_18).into(quiz_word_problem);
                setChoice("물","집","배","돈");     // 보기 설정
                setSolution(2, "dd");
                break;
            case 18:
                Glide.with(this).load(R.drawable.word_problem_19).into(quiz_word_problem);
                setChoice("고수","정수","액상","물");     // 보기 설정
                setSolution(4, "dd");
                break;
            case 19:
                Glide.with(this).load(R.drawable.word_problem_20).into(quiz_word_problem);
                setChoice("셔츠","바지","양말","점퍼");     // 보기 설정
                setSolution(3, "dd");
                break;
            case 20:
                Glide.with(this).load(R.drawable.word_problem_21).into(quiz_word_problem);
                setChoice("운명","인연","필연","우연");     // 보기 설정
                setSolution(1, "dd");
                break;
            case 21:
                Glide.with(this).load(R.drawable.word_problem_22).into(quiz_word_problem);
                setChoice("모뎀","스캐너","프린터","공유기");     // 보기 설정
                setSolution(4, "dd");
                break;
            case 22:
                Glide.with(this).load(R.drawable.word_problem_23).into(quiz_word_problem);
                setChoice("시각","청각","촉각","후각");     // 보기 설정
                setSolution(1, "dd");
                break;
            case 23:
                Glide.with(this).load(R.drawable.word_problem_24).into(quiz_word_problem);
                setChoice("공부","휴식","식사","여가");     // 보기 설정
                setSolution(1, "dd");
                break;
            case 24:
                Glide.with(this).load(R.drawable.word_problem_25).into(quiz_word_problem);
                setChoice("애플","고글","어플","샘물");     // 보기 설정
                setSolution(3, "dd");
                break;
            case 25:
                Glide.with(this).load(R.drawable.word_problem_26).into(quiz_word_problem);
                setChoice("청소기","세탁기","세면대","다리미");     // 보기 설정
                setSolution(2, "dd");
                break;
            case 26:
                Glide.with(this).load(R.drawable.word_problem_27).into(quiz_word_problem);
                setChoice("헤드폰","이어폰","키보드","마우스");     // 보기 설정
                setSolution(4, "dd");
                break;
            case 27:
                Glide.with(this).load(R.drawable.word_problem_28).into(quiz_word_problem);
                setChoice("티슈","걸레","행주","휴지");     // 보기 설정
                setSolution(4, "dd");
                break;
            case 28:
                Glide.with(this).load(R.drawable.word_problem_29).into(quiz_word_problem);
                setChoice("눈물","지하수","강물","약수");     // 보기 설정
                setSolution(1, "dd");
                break;
            case 29:
                Glide.with(this).load(R.drawable.word_problem_30).into(quiz_word_problem);
                setChoice("상품권","관람객","영화관","할인권");     // 보기 설정
                setSolution(3, "dd");
                break;
        }

    }


    public int onChoiceCheck(){     // 사용자가 어떤 정답을 제출했는지 int형으로 반환
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (quiz_word_checkbox1.isChecked() == true)
            result.add(1);
        if (quiz_word_checkbox2.isChecked() == true)
            result.add(2);
        if (quiz_word_checkbox3.isChecked() == true)
            result.add(3);
        if (quiz_word_checkbox4.isChecked() == true)
            result.add(4);

        if (result.size() != 1) {
            Toast.makeText(this, "하나만 선택해주세요.", Toast.LENGTH_SHORT).show();
            return -1;
        }

        return result.get(0);

    }


    public void setChoice(String choice1, String choice2, String choice3, String choice4){  // 주어진 보기를 세팅
        quiz_word_choice_1.setText(" ① " + choice1);
        quiz_word_choice_2.setText(" ② " + choice2);
        quiz_word_choice_3.setText(" ③ " + choice3);
        quiz_word_choice_4.setText(" ④ " + choice4);
    }


    public void setSolution(int solution, String commentary){   // 주어진 정답을 세팅
        this.solution = solution;
        switch(solution){
            case 1:
                quiz_word_solution.setText("①");
                break;
            case 2:
                quiz_word_solution.setText("②");
                break;
            case 3:
                quiz_word_solution.setText("③");
                break;
            case 4:
                quiz_word_solution.setText("④");
                break;
            default:
                quiz_word_solution.setText("[잘못된 문제입니다]");
                break;
        }
        quiz_word_commentary.setText(commentary);
    }

    public void onCheckRefresh(){
        quiz_word_checkbox1.setChecked(false);
        quiz_word_checkbox2.setChecked(false);
        quiz_word_checkbox3.setChecked(false);
        quiz_word_checkbox4.setChecked(false);
    }

    public void setCheckable(boolean command){
        quiz_word_checkbox1.setEnabled(command);
        quiz_word_checkbox2.setEnabled(command);
        quiz_word_checkbox3.setEnabled(command);
        quiz_word_checkbox4.setEnabled(command);
    }

    public void setBeforeChecked(int command){  // 전에 체크한 것
        setCheckable(false);
        switch(command) {
            case 0: // 전에 안푼거
                setCheckable(true);
                break;
            case 1:
                quiz_word_checkbox1.setChecked(true);
                break;
            case 2:
                quiz_word_checkbox2.setChecked(true);
                break;
            case 3:
                quiz_word_checkbox3.setChecked(true);
                break;
            case 4:
                quiz_word_checkbox4.setChecked(true);
                break;
            default:
                break;
        }
    }

}
