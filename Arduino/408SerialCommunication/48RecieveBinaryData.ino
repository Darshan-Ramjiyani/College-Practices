
String data, subData1, subData2;
long binaryNumber;
int baudRate = 9600;

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

void loop()
{
  Serial.println("Provide data.");
  while (Serial.available() == 0)
  {
    ;
  }
  Serial.print("Data Recieved : ");
  data = Serial.readString();
  Serial.println(data);
  splitTheData();
  Serial.print("X-Coordination : ");
  Serial.print(convertBinaryToDecimal((long)subData1.toInt()));
  Serial.print(" Y-Coordination : ");
  Serial.println(convertBinaryToDecimal((long)subData2.toInt()));
  delay(1000);
  Serial.println("done");
}

void splitTheData()
{
  int sep_pos = data.indexOf(",");
  subData1 = data.substring(0, sep_pos);
  subData2 = data.substring(sep_pos + 1, data.length());
}

long convertBinaryToDecimal(long binary)
{

  long number = binary;
  long decimalVal = 0;
  long baseVal = 1;
  long tempVal = number;
  long previousDigit;

  while (tempVal)
  {

    // Converts Binary to Decimal
    previousDigit = tempVal % 10;
    tempVal = tempVal / 10;
    decimalVal += previousDigit * baseVal;
    baseVal = baseVal * 2;
  }

  // Returns the Decimal number
  return decimalVal;
}
