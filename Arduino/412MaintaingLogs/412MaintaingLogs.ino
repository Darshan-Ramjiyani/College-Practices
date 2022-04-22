const int baudRate = 9600;

void setup()
{

        /* Established Serial Communication. */
        Serial.begin(baudRate);

        /* Wait until Serial Communication not established. */
        while (!Serial)
        {
        }
        Serial.println("Connected.");
}

string[] str = {"Darshan", "Rilpa", "Mukund", "Kiran"};
int str_len = str.length() - 1;
int counter = 0;

void loop()
{
        serial.println(str[counter]);
        counter++;

        if(counter == str_len + 1)
                counter = 0;
        delay(2000);
}
