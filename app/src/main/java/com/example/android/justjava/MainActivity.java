package com.example.android.justjava; /**

 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.

 * This is the package name our example uses:

 *

 * package com.example.android.justjava;

 *

 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.android.justjava.R;

import java.text.NumberFormat;


/**

 * This app displays an order form to order coffee.

 */

public class MainActivity extends AppCompatActivity {

    int quantity=2;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }



    /**

     * This method is called when the order button is clicked.

     */

    public void submitOrder(View view) {
        // Figure oput if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream: " + hasWhippedCream);

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        //Calculate the price
        int price=calculatePrice();

        //Display the order summary on the screen
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        priceMessage = priceMessage + "\nThank you!";
        displayMessage(priceMessage); }

    /**

     * Calculates the price of the order.

     *@return total price

     */

    private int calculatePrice() {
       return quantity*5;


    }
    /**
     * Create summary of the order.
     *
     * @param price of the order.
     * @param addWhippedCream is whether or not the user wants whipped cream topping.
     * @param addChocolate is whether or not the user wants chocolate topping
     */
     private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
         String priceMessage = "Name: Lyla the Labyrinth";
         priceMessage += "Add whipped cream? " + addWhippedCream;
         priceMessage +="Add chocolate?" + addChocolate;
         priceMessage += "\nQuantity: " + quantity;
         priceMessage += "\nTotal: $" + price;
         priceMessage += "\nThank you!";
         return priceMessage;
     }


    /**

     * This method displays the given text on the screen.

     */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**

     * This method is called when the plus button is clicked.

     */


    public void increment(View view) {


        quantity=quantity+1;
        display(quantity);


    }
    /**

     * This method is called when the minus button is clicked.

     */

    public void decrement(View view) {

        quantity=quantity-1;
        display(quantity);

    }


    /**

     * This method displays the given quantity value on the screen.

     */

    private void display(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        quantityTextView.setText("" + number);

    }

    /**

     * This method displays the given price on the screen.

     */

    private void displayPrice(int number) {

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);

        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }



}