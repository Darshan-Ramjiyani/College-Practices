int LEDPin = 13;
int baughtRate = 9600;

void setup()
{
  pinMode(LEDPin, OUTPUT);
  Serial.begin(baughtRate);
   
  Serial.println("Connection Establishing connection...!");
  while(!Serial){}
  Serial.println("Connection Established!");
}

void loop()
{
  char ch;
  Serial.println("Waiting for integeral data from 0 to 9...");
  while(Serial.available() == 0){}
  if(Serial.available() > 0 )
  {
    ch = Serial.read();
    int count;
    if(isDigit(ch))
    {
      Serial.print("LED blinks ");  
      Serial.print(ch - '0');
      Serial.println(" times.");
      count = ch - '0';
      for(int i = 0; i < ch - '0'; i++)
      {
        digitalWrite(LEDPin, HIGH);
        delay(1000);
        digitalWrite(LEDPin, LOW);
        delay(1000); 
        Serial.println(count - i);
      }
      Serial.println("Blinking Process Done");
    }
  }
}
