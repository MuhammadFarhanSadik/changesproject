
package farhans.weatherconsolapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherAppGUI extends JFrame {

    private JTextField countryField;
    private JTextField cityField;
    private JTextArea resultArea;
    private JButton fetchButton;

    private WeatherApp weatherApp;

    public WeatherAppGUI() {
        super("Weather App");

        weatherApp = new WeatherApp();

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // center the window

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Country Code (e.g. BD):"));
        countryField = new JTextField();
        inputPanel.add(countryField);

        inputPanel.add(new JLabel("City:"));
        cityField = new JTextField();
        inputPanel.add(cityField);

        fetchButton = new JButton("Get Weather");
        inputPanel.add(fetchButton);

        add(inputPanel, BorderLayout.NORTH);

        // Output panel
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        // Button action
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String country = countryField.getText().trim();
                String city = cityField.getText().trim();

                if (city.isEmpty() || country.isEmpty()) {
                    JOptionPane.showMessageDialog(WeatherAppGUI.this, "Please enter both country and city.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String result = weatherApp.getWeatherAsString(city, country);
                resultArea.setText(result);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new WeatherAppGUI();
    }
}

