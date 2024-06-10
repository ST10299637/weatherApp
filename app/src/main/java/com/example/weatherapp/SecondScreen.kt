import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainScreenActivity : AppCompatActivity() {

    // Sample data for the week
    private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val minTemperatures = arrayOf(12, 15, 0, 0, 0, 10, 10) // Replace 0 with actual min temperatures
    private val maxTemperatures = arrayOf(25, 29, 0, 0, 0, 18, 16) // Replace 0 with actual max temperatures
    private val weatherConditions = arrayOf("Sunny", "Sunny", "", "", "", "Raining", "Cold")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val averageTemperatureTextView: TextView = findViewById(R.id.average_temperature)
        val detailViewButton: Button = findViewById(R.id.detail_view_button)
        val clearDataButton: Button = findViewById(R.id.clear_data_button)
        val exitAppButton: Button = findViewById(R.id.exit_app_button)

        // Calculate and display the average temperature
        val averageTemperature = calculateAverageTemperature(minTemperatures, maxTemperatures)
        averageTemperatureTextView.text = "Average Temperature: $averageTemperature"

        // Set up button listeners
        detailViewButton.setOnClickListener {
            // Navigate to the Detailed View Screen
            val intent = Intent(this, DetailedActivity::class.java)
            startActivity(intent)
        }

        clearDataButton.setOnClickListener {
            // Clear the data and allow the user to re-input
            clearData()
        }

        exitAppButton.setOnClickListener {
            // Exit the app
            finish()
        }
    }

    private fun calculateAverageTemperature(minTemps: Array<Int>, maxTemps: Array<Int>): Double {
        var sum = 0.0
        var count = 0
        for (i in minTemps.indices) {
            if (minTemps[i] > 0 && maxTemps[i] > 0) { // Assuming 0 is not a valid temperature
                sum += (minTemps[i] + maxTemps[i]) / 2.0
                count++
            }
        }
        return if (count > 0) sum / count else 0.0
    }

    private fun clearData() {
        // Clear the arrays or reset them to default values
        // This is a placeholder for your clear data logic
    }
}