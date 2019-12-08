package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var carPriceInput: EditText
    lateinit var downPaymentInput: EditText
    lateinit var loanPeriodInput: EditText
    lateinit var interestRateInput: EditText
    lateinit var carLoanTextView: TextView
    lateinit var interestTextView: TextView
    lateinit var monthlyRepaymentTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carPriceInput = findViewById(R.id.editTextCarPrice)
        downPaymentInput = findViewById(R.id.editTextDownPayment)
        loanPeriodInput = findViewById(R.id.editTextLoanPeriod)
        interestRateInput = findViewById(R.id.editTextInterestRate)
        carLoanTextView = findViewById(R.id.textViewLoan)
        interestTextView = findViewById(R.id.textViewInterest)
        monthlyRepaymentTextView = findViewById(R.id.textViewMonthlyRepayment)

        val calculateButton: Button = findViewById(R.id.buttonCalculate)
        val resetButton: Button = findViewById(R.id.buttonReset)

        calculateButton.setOnClickListener{ calculate() }
        resetButton.setOnClickListener{ reset() }
    }

    private fun calculate(){
        val carLoan = Integer.parseInt(carPriceInput.text.toString()) - Integer.parseInt(downPaymentInput.text.toString())
        val interest = Integer.parseInt(carPriceInput.text.toString()) * Integer.parseInt(interestRateInput.text.toString())/100 * Integer.parseInt(loanPeriodInput.text.toString())
        val repayment = (Integer.parseInt(carPriceInput.text.toString()) + Integer.parseInt(interest.toString())) / Integer.parseInt(loanPeriodInput.text.toString()) / 12

        carLoanTextView.setText("Loan: "+carLoan.toString())
        interestTextView.setText("Interest: "+interest.toString())
        monthlyRepaymentTextView.setText("Monthly Repayment: "+ repayment.toString())
    }

    private fun reset(){
        carPriceInput.setText("")
        downPaymentInput.setText("")
        loanPeriodInput.setText("")
        interestRateInput.setText("")

        carLoanTextView.setText("Loan: ")
        interestTextView.setText("Interest: ")
        monthlyRepaymentTextView.setText("Monthly Repayment: ")

    }
}
