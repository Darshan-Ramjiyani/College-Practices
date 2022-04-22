from time import sleep
import pyautogui
import serial

PORT: str = "com9"
BAUD_RATE: int = 9600
CONN: serial.Serial = None


def main():
    setup()
    while True:
        loop()


def setup():
    global BAUD_RATE, CONN, PORT

    print("[Python] : Connecting Dwaidh terminal to Arduino. Please wait...")
    while True:
        try:
            CONN = serial.Serial(PORT, BAUD_RATE)
            print(
                f"[Python] : Dwaidh terminal connected to the Arduino via {PORT} at {BAUD_RATE} bps.")
            break
        except serial.SerialException as e:
            print(
                "[Python] : Can not connect to the port. Try again in 2 mininutes. ", e.args)
            from time import sleep
            sleep(2)

    while True:
        receive_data: str = CONN.readline().decode("ascii")
        if len(receive_data) > 0:
            if "Connected" in receive_data:
                print("[Python] : Arduino has successfully verify the connection.")
                break
            else:
                print(f"[Arduino]: {receive_data}")
        continue


def loop():
    while True:
        receive_data: str = CONN.readline().decode("ascii")

        if len(receive_data) > 0:
            if "Provide data" in receive_data:
                x_coordination, y_coordination = pyautogui.position()
                print(f"[Python] : Sending ({x_coordination},{y_coordination}) as ({format(x_coordination, '08b')}, "
                      f"{format(y_coordination, '08b')}) to the Arduino.")
                ""
                CONN.write(bytes(""+format(x_coordination, '08b') +
                           ","+format(y_coordination, '08b'), "ascii"))
            elif "done" in receive_data:
                print("[Arduino]: Process done.")
                x = input("[Python] : Press Y then enter to continue.")
                if x.lower() == 'y':
                    continue
                else:
                    print("[Python] : Closing the connection with Arduino...")
                    CONN.close()
                    print("[Python] : Connection has been closed.")
                    exit(0)
            else:
                print(f"[Arduino]: {receive_data}")
        sleep(1)


if __name__ == '__main__':
    main()
