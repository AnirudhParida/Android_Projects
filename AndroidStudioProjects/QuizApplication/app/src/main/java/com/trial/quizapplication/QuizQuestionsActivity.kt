package com.trial.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var mselectedoption:Int=0
    private var mquestionlist:ArrayList<Questions>?=null
    private var mcurrentposition:Int = 1
    private var musername:String ?=null
    private var mcorrectanswer :Int =0


    private var progressbar : ProgressBar?=null
    private var tvprogress:TextView?=null
    private var ivimage:ImageView?=null
    private var tvquestion:TextView?=null

    private var option1:TextView?=null
    private var option2:TextView?=null
    private var option3:TextView?=null
    private var option4:TextView?=null

    private var btnsubmit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestions)

        musername=intent.getStringExtra(Constants.USER_NAME)

        progressbar=findViewById(R.id.progress_bar)
        tvprogress=findViewById(R.id.tv_progress)
        ivimage=findViewById(R.id.ivimage)
        tvquestion=findViewById(R.id.question)
        option1=findViewById(R.id.option1)
        option2=findViewById(R.id.option2)
        option3=findViewById(R.id.option3)
        option4=findViewById(R.id.option4)
        btnsubmit=findViewById(R.id.Submit_button)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)

        val questionlist = Constants.getQuestions()
        setquestion()

    }


    private fun setquestion() {

        defaultoptionview()

        val question: Questions = mquestionlist!![mcurrentposition - 1]

        ivimage?.setImageResource(question.img)

        progressbar?.progress = mcurrentposition

        tvprogress?.text = "$mcurrentposition/${progressbar?.max}"

        tvquestion?.text = question.question

        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4

        if(mcurrentposition==mquestionlist!!.size){
            btnsubmit?.text="FINISH"
        }else{
            btnsubmit?.text="NEXT"
        }
    }

    private fun defaultoptionview(){
        var options = ArrayList<TextView>()
        option1?.let {
            options.add(1,it)
        }
        option2?.let {
            options.add(2,it)
        }
        option3?.let {
            options.add(3,it)
        }
        option4?.let {
            options.add(4,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("00f5d4"))
            option.typeface = Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border)
        }
    }

    private fun selectedoptionview(selctedoption:Int,tv:TextView){
        defaultoptionview()
        mselectedoption = selctedoption
        tv.setTextColor(Color.parseColor("9d0208"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_bg)
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1->{
                option1?.let {
                    selectedoptionview(1,it)
                }
            }
            R.id.option2->{
                option2?.let {
                    selectedoptionview(2,it)
                }
            }
            R.id.option3->{
                option3?.let {
                    selectedoptionview(3,it)
                }
            }
            R.id.option4->{
                option4?.let {
                    selectedoptionview(4,it)
                }
            }
            R.id.Submit_button->{
                if (mselectedoption==0){
                    mcurrentposition++
                    when{
                        mcurrentposition<=mquestionlist!!.size-1->{
                            setquestion()
                        }
                        else->{
                            val intent = Intent(this,Result_Activity::class.java)
                            intent.putExtra(Constants.USER_NAME,musername)
                            intent.putExtra(Constants.CORRECT_ANSWER,mcorrectanswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mquestionlist?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mquestionlist?.get(mcurrentposition-1)
                    if (question!!.correct_answer!=mselectedoption){
                        answerview(mselectedoption,R.drawable.wrong_option_bg)
                    }
                    else{
                        mcorrectanswer++
                    }
                    answerview(mselectedoption,R.drawable.correct_option_bg)
                }
            }
        }
    }
    private fun answerview(answer:Int,drawable:Int){
        when(answer){
            1->{
                option1?.background=ContextCompat.getDrawable(
                    this, drawable
                )
            }
            2->{
                option2?.background=ContextCompat.getDrawable(
                    this, drawable
                )
            }
            3->{
                option3?.background=ContextCompat.getDrawable(
                    this, drawable
                )
            }
            4->{
                option4?.background=ContextCompat.getDrawable(
                    this, drawable
                )
            }
        }

    }
}