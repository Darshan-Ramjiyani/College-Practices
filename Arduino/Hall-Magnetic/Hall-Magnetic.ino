int led = 13;//LED pin
int sensor = 3; //sensor pin
int val; //numeric variable
void setup()
{
	pinMode(led, OUTPUT); //set LED pin as output
	pinMode(sensor, INPUT); //set sensor pin as input
    while (!Serial)
    {
        Serial.begin(9600);
    }
    
}
void loop()
{
	val = digitalRead(sensor); //Read the sensor
	if(val == LOW) //when magnetic field is detected, turn led on
	{
		digitalWrite(Led, HIGH);
        Serial.println("Magnetic Field Found.");
	}
	else
	{
		digitalWrite(Led, LOW);
	}
}