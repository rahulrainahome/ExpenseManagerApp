package app.expense.org.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import app.expense.org.Model.Expense;
import app.expense.org.expensemanagerapp.R;
import app.expense.org.utils.Constants;

/**
 * Created by user on 13/1/16.
 */
public class ExpenseViewAdapter extends ArrayAdapter<Expense> {

    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<Expense> list;

    public ExpenseViewAdapter(Activity activity, ArrayList<Expense> list) {
        super(activity, R.layout.listviewitem_expense_view, list);

        this.activity = activity;
        this.inflater = activity.getLayoutInflater();
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.listviewitem_expense_view, null);

        TextView textItem = view.findViewById(R.id.textViewItem);
        TextView textDateTime = view.findViewById(R.id.textViewTime);
        TextView textAccount = view.findViewById(R.id.textViewAccount);
        TextView sideColor = view.findViewById(R.id.indicatorSideBar);
        TextView priceExpense = view.findViewById(R.id.txtPriceExpense);

        Expense expense = Constants.expenseData.get(position);

        textItem.setText(expense.spenton);
        priceExpense.setText("Rs." + expense.price);
        textDateTime.setText(expense.datetime);
        textAccount.setText(expense.category + "\n" + expense.account);
        sideColor.setText("" + (position + 1));

        return view;
    }
}
