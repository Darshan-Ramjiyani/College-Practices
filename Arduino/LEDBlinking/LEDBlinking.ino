/*
 * Blink the LED. (Defination1)
 * @author: DSP
 * Licence: Apache 2.0
 */

 int led = 9;

 void setup()
 {
    pinMode(led, OUTPUT);
 }

void loop()
{
    for(int i=0; i<=255;)
    {
      analogWrite(led, i);
      delay(100);
      i = i+10;
    }
    delay(500);
    for(int i=255; i>=0;)
    {
      analogWrite(led, i);
      delay(100);
       i = i-10;
    }
    
}
