def to_result(arr):
    if arr is None:
        return None

    res = ''
    for c in arr:
        res += c.strip() + ' '

    return res.rstrip()


def task(inner):
    def outer(data):
        if len(data) < 2:
            return None

        arr = data[1].split(' ')

        return to_result(inner(arr))

    return outer


@task
def selection(arr):
    if len(arr) > 10000:
        return None

    for i in range(len(arr)):
        min_val = int(arr[i])
        min_ind = i

        for j in range(i + 1, len(arr)):
            val = int(arr[j])

            if val < min_val:
                min_val = val
                min_ind = j

        arr[i], arr[min_ind] = arr[min_ind], arr[i]

    return arr


@task
def insertion(arr):
    if len(arr) > 10000:
        return None

    for i in range(1, len(arr)):
        val = arr[i]
        j = i - 1

        while j >= 0 and int(arr[j]) > int(val):
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = val

    return arr


@task
def shell(arr):
    gap = len(arr) // 2
    while gap > 0:
        for i in range(len(arr) - gap):
            j = i + gap
            val = arr[j]

            while j - gap >= 0 and int(arr[j - gap]) > int(val):
                arr[j] = arr[j - gap]
                j -= gap

            arr[j] = val
        gap //= 2

    return arr


def heapify(arr, root, size):
    l = 2 * root + 1
    r = l + 1
    x = root

    if l < size and int(arr[x]) < int(arr[l]):
        x = l
    if r < size and int(arr[x]) < int(arr[r]):
        x = r
    if x == root:
        return

    arr[x], arr[root] = arr[root], arr[x]
    heapify(arr, x, size)


@task
def heap(arr):
    for i in range(len(arr) // 2, -1, -1):
        heapify(arr, i, len(arr))

    for i in range(len(arr) - 1, -1, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, 0, i)

    return arr
