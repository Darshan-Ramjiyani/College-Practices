from time import sleep
import pyautogui
import serial
import sys

PORT: str = "com9"
BAUD_RATE: int = 9600
CONN: serial.Serial = None

pyautogui.FAILSAFE = False


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
            if "Data" in receive_data:
                x_coordinate = int(receive_data.split(",")[1])
                y_coordinate = int(receive_data.split(",")[2])
                print(f"[Python] : Moving mouse to ({x_coordinate},{y_coordinate})")
                sleep(1)
                try:
                    pyautogui.moveTo(x_coordinate, y_coordinate, 3, pyautogui.easeInQuad)
                except KeyboardInterrupt as e:
                    sys.exit()
                sleep(5)
            else:
                print(f"[Arduino]: {receive_data}")
                sleep(5)


if __name__ == "__main__":
    main()
