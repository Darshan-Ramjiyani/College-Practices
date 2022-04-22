const int buttonPin = 2;
const int baudRate = 9600;
const int potXPin = 4;
const int potYPin = 5;

void setup()
{
        /* Setting pins for input. */
        pinMode(buttonPin, INPUT);
        digitalWrite(buttonPin, HIGH);

        /* Established Serial Communication. */
        Serial.begin(baudRate);

        /* Wait until Serial Communication not established. */
        while (!Serial)
        {
        }
        Serial.println("Connected.");
}

void loop()
{
        int x = (512 - analogRead(potXPin)) / 4;
        int y = (512 - analogRead(potYPin)) / 4;
        Serial.print("Data,");
        Serial.print(x, DEC);
        Serial.print(",");
        Serial.print(y, DEC);
        Serial.print(",");
        if (digitalRead(buttonPin) == LOW)
                Serial.print(1);
        else
                Serial.print(0);
        Serial.println(",");
        delay(1000);
}
