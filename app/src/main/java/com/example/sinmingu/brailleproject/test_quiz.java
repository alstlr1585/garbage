package com.example.sinmingu.brailleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

import static com.example.sinmingu.brailleproject.R.id.quiz_word_checkbox1;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_checkbox2;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_checkbox3;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_checkbox4;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_choice_1;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_choice_2;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_choice_3;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_choice_4;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_commentary;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_problem;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_problem_number;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_rightAnswer;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_solution;
import static com.example.sinmingu.brailleproject.R.id.quiz_word_wrongAnswer;
import static com.example.sinmingu.brailleproject.R.id.stduy_part;

public class test_quiz extends BaseActivity {


    //o,x 이미지 버튼 클릭
    ImageButton click_o, click_x;
    //o,x 상태변화 변수

    int status = 0;
    int problem_now;
    int solution, problemCount = 15;
    //확인버튼
    Button test_result;
    Button before, next;
    // 문제
    TextView problem;
    TextView quiz_word_solution, quiz_word_commentary, quiz_word_rightAnswer, quiz_word_wrongAnswer, quiz_word_problem_number;;



    Random random;
    ArrayList<Integer> problemHistory, checkFlag, userSolutionHistory;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_quiz);


        test_result = (Button) findViewById(R.id.test_result);
        before = (Button) findViewById(R.id.before);
        next = (Button) findViewById(R.id.next);

        // 문제
        problem = (TextView) findViewById(R.id.problem);

        // o , x
        click_o = (ImageButton) findViewById(R.id.click_o);
        click_x = (ImageButton) findViewById(R.id.click_x);

        // 랜덤 돌리기용
        random = new Random();

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

        // 지나온 문제 남기기 위한 배열과 현재가 몇번문제인지 알기위한 int 변수
        problemHistory = new ArrayList<Integer>();
        problem_now = 0;

        // 맞은 문제, 틀린 문제 세탁 방지용
        checkFlag = new ArrayList<Integer>();

        // 과거 답안 저장용
        userSolutionHistory = new ArrayList<Integer>();

        quiz_word_solution.setVisibility(View.INVISIBLE);   // 초기엔 투명화
        quiz_word_commentary.setVisibility(View.INVISIBLE);

        onNextClick(next);

        Glide.with(this).load(R.drawable.o_uncheck).fitCenter().fitCenter().into(click_o);
        Glide.with(this).load(R.drawable.x_uncheck).fitCenter().fitCenter().into(click_x);

        click_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status == 1) {
                    Glide.with(test_quiz.this).load(R.drawable.o_check).fitCenter().into(click_o);
                } else {
                    Glide.with(test_quiz.this).load(R.drawable.o_check).fitCenter().into(click_o);
                    Glide.with(test_quiz.this).load(R.drawable.x_uncheck).fitCenter().into(click_x);
                }
                status = 1;
            }
        });

        click_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status == 2) {
                    Glide.with(test_quiz.this).load(R.drawable.x_check).fitCenter().into(click_x);
                } else {
                    Glide.with(test_quiz.this).load(R.drawable.x_check).fitCenter().into(click_x);
                    Glide.with(test_quiz.this).load(R.drawable.o_uncheck).fitCenter().into(click_o);
                }
                status = 2;
            }
        });


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

        if (onChoiceCheck() == solution) {    // 선택한 것이 정답이라면
            quiz_word_rightAnswer.setText("" + (Integer.parseInt(quiz_word_rightAnswer.getText().toString()) + 1));
        }
        else{
            quiz_word_wrongAnswer.setText("" + (Integer.parseInt(quiz_word_wrongAnswer.getText().toString()) + 1));
        }
        userSolutionHistory.set(problem_now-1, onChoiceCheck());
    }


    public void setProblem(int problemNumber){  // 새로운 문제 출제
        onCheckRefresh();

        quiz_word_problem_number.setText("" + problem_now + "번 문제");

        switch(problemNumber){
            // 문제 설정
            case 0:
                problem.setText("‘그러면’은 약어로 나타낼 수 없다");

                setSolution(2, "‘그러면’은 약어로 나타낼 수 있다.");
                break;
            case 1:
                problem.setText("서예는 (ㅅ), (ㅓ), (ㅖ) 로 구분하여 입력한다.");
                setSolution(2, "모음자에 ‘예’가 이어 나올때에는 그 사이에 붙임표를 적어 나타낸다.");
                break;
            case 2:
                problem.setText("초성자음과 종성자음들은 같은 점자를 사용하여 표현한다.");
                setSolution(2, "초성자음을 나타내는 점자와 종성자음을 나타내는 점자가 따로있어 문장을 만들 때 위치에 따라서 다르게 표현해주어야 한다.");
                break;
            case 3:
                problem.setText("‘ㅇ’이 첫소리 자리에 쓰일 때에는 표기하지 않는다.");
                setSolution(2, "기본적으로는 생략하나특수한 경우에는 반드시 표기해야한다.");
                break;
            case 4:
                problem.setText("‘ㅑ’, ‘ㅘ’, ‘ㅜ’, ‘ㅝ’ 뒤에 '애'가 이어서 나올때에는 그 사이에 붙임표를 적어 나타낸다");
                setSolution(1, "‘야애’ 와 같이 음절의 경우 ‘야’와 ‘애’사이에 붙임표를 적어야한다.");
                break;
            case 5:
                problem.setText("‘ㄱ’과 ‘가’는 같은 점자이다.");
                setSolution(2, "‘가’에 해당하는 약자가 따로 있다.");
                break;
            case 6:
                problem.setText("겹받침인 ‘ㄳ’, ‘ㄺ’, ‘ㅀ’ 들은 각 자음자의 받침 표기를 이용해 어울러 적는다.");
                setSolution(1, "‘ㄳ’, ‘ㄺ’, ‘ㅀ’은 각각 ‘ㄱ’과 ‘ㅅ’, ‘ㄹ’과 ‘ㄱ’, ‘ㄹ’과 ‘ㅎ’으로 적는다.");
                break;
            case 7:
                problem.setText("쌍받침 ‘ㅆ’은 각 자음자의 받침 표기를 이용해 어울러 적는다.");
                setSolution(2, "‘ㅆ’은 (3-4점)으로 표기한다.");
                break;
            case 8:
                problem.setText("첫소리 자리에 ‘ㅇ’는 표기할 수가 없다.");
                setSolution(2, "‘ㅇ’은 첫소리 자리에 사용할 수 있다.");
                break;
            case 9:
                problem.setText("된소리 글자 ‘ㄲ, ㄸ, ㅃ, ㅆ, ㅉ’이 첫소리 자리에 쓰일 때에는 각각 ‘ㄱ, ㄷ, ㅂ, ㅅ, ㅈ’ 앞에 된소리표를 적어서 나타낸다.");
                setSolution(1, "된소리표 뒤에 ‘ㄱ’을 사용하면 ‘ㄲ’이 된다.");
                break;
            case 10:
                problem.setText("자음자나 모음자가 단독으로 글자앞에 온표를 적어 나타낸다.");
                setSolution(1, "자음, 모음자를 단독으로 사용하고 싶을 경우 글자앞에 온표를 사용한다.");
                break;
            case 11:
                problem.setText("‘가’, ‘나’, ‘다’, ‘마,’ ‘바’, ‘자’, ‘카’, ‘타’, ‘파’, ‘하’ 뒤에 모음이 나올때에는 ‘ㅏ’를 생략하지 않고 적는다.");
                setSolution(2, "'가‘는 포함되지 않는다.");
                break;
            case 12:
                problem.setText("‘쭈그리고’, ‘찡그리고’ 앞에 다른 음절이 붙어 있을 때에도 약어를 사용한다.");
                setSolution(2, "약어 앞에 음절이 붙어있는 경우에는 ‘그리고’와 같은 약어를 사용하지 않고 표현한다. ");
                break;
            case 13:
                problem.setText("알파벳을 표기하는 방법중에 소문자와 대문자는 같은 점자로 표현한다.");
                setSolution(2, "대문자는 소문자와 구분하기 위하여 알파벳 앞에 된소리표를 넣는다.");
                break;
            case 14:
                problem.setText("‘그래서인지’, ‘그러면서’와 같은 말 뒤에 다른 음절이 붙을 때에도 약어를 사용한다.");
                setSolution(1, "‘그래서인지’는 ‘그래서’ 약자를 사용하고 ‘인지’를 더해 ‘그래서인지’로 표현하고 ‘그러면서’ 역시 ‘그러면’ 약자를 사용하고 ‘서’를 더해 ‘그러면서’로 표현한다.");
                break;
        }

    }


    public int onChoiceCheck(){     // 사용자가 어떤 정답을 제출했는지 int형으로 반환
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(status == 1)
            result.add(1);
        if(status == 2)
            result.add(2);

        if (result.size() != 1) {
            Toast.makeText(this, "하나만 선택해주세요.", Toast.LENGTH_SHORT).show();
            return -1;
        }

        return result.get(0);

    }

    public void setSolution(int solution, String commentary){   // 주어진 정답을 세팅
        this.solution = solution;
        switch(solution){
            case 1:
                quiz_word_solution.setText("O");
                break;
            case 2:
                quiz_word_solution.setText("X");
                break;
            default:
                quiz_word_solution.setText("[잘못된 문제입니다]");
                break;
        }
        quiz_word_commentary.setText(commentary);
    }

    public void onCheckRefresh(){
        status = 0;
        Glide.with(test_quiz.this).load(R.drawable.o_uncheck).fitCenter().into(click_o);
        Glide.with(test_quiz.this).load(R.drawable.x_uncheck).fitCenter().into(click_x);
    }

    public void setCheckable(boolean command){
        click_o.setEnabled(command);
        click_x.setEnabled(command);
    }

    public void setBeforeChecked(int command){  // 전에 체크한 것
        setCheckable(false);
        switch(command) {
            case 0: // 전에 안푼거
                setCheckable(true);
                break;
            case 1:
                Glide.with(test_quiz.this).load(R.drawable.o_check).fitCenter().into(click_o);
                break;
            case 2:
                Glide.with(test_quiz.this).load(R.drawable.x_check).fitCenter().into(click_x);
                break;

            default:
                break;
        }
    }

}
