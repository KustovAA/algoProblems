def task(data):
    if len(data) < 1:
        return None

    fen = data[0]

    board = {}
    blacks = {'r', 'n', 'b', 'q', 'k', 'p'}
    whites = {'R', 'N', 'B', 'Q', 'K', 'P'}
    table = fen.split('/')

    for i in range(len(table) - 1, -1, -1):
        pos = 0
        for c in table[i]:
            if c in blacks or c in whites:
                value = 1 << (len(table) - 1 - i) * 8 + pos
                if c in board:
                    board[c] |= value
                else:
                    board[c] = value
                pos += 1
            elif c.isdigit():
                pos += int(c)

    result = [
        board.get('P', 0),
        board.get('N', 0),
        board.get('B', 0),
        board.get('R', 0),
        board.get('Q', 0),
        board.get('K', 0),
        board.get('p', 0),
        board.get('n', 0),
        board.get('b', 0),
        board.get('r', 0),
        board.get('q', 0),
        board.get('k', 0)
    ]

    return '{0} {1} {2} {3} {4} {5} {6} {7} {8} {9} {10} {11}'.format(*result)
