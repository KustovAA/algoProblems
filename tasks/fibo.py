def iterative(data):
    if len(data) < 1:
        return None

    n = int(data[0])
    if n < 2:
        return str(n)

    f = 0
    f1 = 1

    for i in range(2, n + 1):
        f, f1 = f1, f + f1

    return str(f1)


def m_identity():
    return [
        [1, 0],
        [0, 1]
    ]


def m_base():
    return [
        [1, 1],
        [1, 0]
    ]


def multiply_matrix(m1, m2):
    res = [
        [0, 0],
        [0, 0]
    ]

    for i in range(2):
        for j in range(2):
            res[i][j] = 0

            for k in range(2):
                res[i][j] += m1[i][k] * m2[k][j]

    return res


def power_matrix(n):
    res = m_identity()
    base = m_base()

    if n == 0:
        return base

    while n > 1:
        if n & 1 == 1:
            res = multiply_matrix(res, base)

        base = multiply_matrix(base, base)
        n >>= 1

    return multiply_matrix(res, base)


def matrix(data):
    if len(data) < 1:
        return None

    n = int(data[0])
    if n <= 2:
        return str(min(n, 1))

    return str(power_matrix(n - 1)[0][0])
