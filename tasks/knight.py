def task(data):
    if len(data) < 1:
        return None

    place = int(data[0])
    k = 1 << place
    k_c_l = k & 0xfefefefefefefefe
    k_f_l = k & 0xfcfcfcfcfcfcfcfc
    k_c_r = k & 0x7f7f7f7f7f7f7f7f
    k_f_r = k & 0x3f3f3f3f3f3f3f3f

    mask_l = (k_c_l << 15) | (k_f_l << 6) | (k_f_l >> 10) | (k_c_l >> 17)
    mask_r = (k_c_r >> 15) | (k_f_r >> 6) | (k_f_r << 10) | (k_c_r << 17)
    mask = mask_l | mask_r

    count = 0
    tmp = mask

    while tmp != 0:
        tmp = tmp & (tmp - 1)
        count += 1

    return f'{count} {mask}'
