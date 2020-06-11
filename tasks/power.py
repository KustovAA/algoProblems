def task(data):
    if len(data) < 2:
        return None

    base, power = (float(i) for i in data)

    if power == 0:
        return '1'

    result = 1.0

    while power > 1:
        if power % 2 != 0:
            result *= base
            power -= 1

        base **= 2
        power /= 2

    return str(result * base)
