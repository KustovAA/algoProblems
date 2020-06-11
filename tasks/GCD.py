def remainder(data):
    if len(data) < 2:
        return None

    a, b = (int(i) for i in data)

    while a != 0 and b != 0:
        if a > b:
            a %= b
        else:
            b %= a

    return str(max(a, b))


def binary(data):
    if len(data) < 2:
        return None

    a, b = (int(i) for i in data)
    multiplicand = 1

    while a != b:
        is_a_updated = False
        is_b_updated = False

        if a % 2 == 0:
            a //= 2
            is_a_updated = True

        if b % 2 == 0:
            b //= 2
            is_b_updated = True

        if is_a_updated and is_b_updated:
            multiplicand *= 2

        if not is_a_updated and not is_b_updated:
            if a > b:
                a -= b
            else:
                b -= a

    return str(a * multiplicand)
