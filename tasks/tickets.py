from functools import reduce


def task(data):
    if len(data) < 1:
        return None

    num = int(data[0])

    res_list = []
    temp_list = []

    for i in range(10):
        res_list.append(1)

    for i in range(num * 9 - 9):
        res_list.append(0)

    for i in range(num - 1):
        for j in range(len(res_list)):
            cnt = 0
            stop = -1 if j - 10 < 0 else j - 10
            for k in range(j, stop, -1):
                cnt += res_list[k]
            temp_list.append(cnt)

        res_list = temp_list
        temp_list = []

    return str(reduce(lambda acc, cur: acc + cur**2, res_list, 0))
