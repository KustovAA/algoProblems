def task(data):
    if len(data) < 1:
        return None

    place = int(data[0])
    k = 1 << place
    k_l = k & 0xfefefefefefefefe
    k_r = k & 0x7f7f7f7f7f7f7f7f

    mask = (k_l << 7) | (k << 8) | (k_r << 9) | (k_l >> 1) | (k_r << 1) | (k_l >> 9) | (k >> 8) | (k_r >> 7)

    count = 0
    tmp = mask

    while tmp != 0:
        tmp = tmp & (tmp - 1)
        count += 1

    return f'{count} {mask}'
