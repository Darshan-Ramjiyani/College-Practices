const int NUMBER_OF_FIELDS = 3;
int fieldIndex = 0;
int values[NUMBER_OF_FIELDS];
void setup()
{
        Serial.begin(9600);
}
void loop()
{
        if (Serial.available() > 0)
        {
                for (fieldIndex = 0; fieldIndex < 3; fieldIndex++)
                {
                        values[fieldIndex] = Serial.parseInt();
                }

                while(Serial.available() > 0)
                {
                        Serial.read();
                }
                
                Serial.print(fieldIndex);
                Serial.println(" fields received:");
                for (int i = 0; i < fieldIndex; i++)
                {
                        Serial.println(values[i]);
                }
                fieldIndex = 0;
        }
}
