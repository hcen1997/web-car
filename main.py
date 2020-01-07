import logging
import control

def loggingConfig():
    log_format = "[%(process)d]%(asctime)s - %(levelname)s - %(message)s"
    logging.basicConfig(
        filename='car.log',
        level=logging.DEBUG,
        format=log_format
    )


def main():
    loggingConfig()
    logging.error('dd')


if __name__ == '__main__':
    main()
