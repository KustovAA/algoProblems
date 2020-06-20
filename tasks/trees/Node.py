from typing import Optional


def height(node):
    if node and node.__height__:
        return node.__height__()

    return 0


class Node:
    def __init__(self, val: int, parent: Optional['Node'] = None):
        self.left: Optional[Node] = None
        self.right: Optional[Node] = None
        self.parent: Optional[Node] = parent
        self.val: int = val

    def insert(self, val):
        if self.val is None:
            self.val = val
            return

        if val < self.val:
            if self.left is None:
                self.left = Node(val, self)
            else:
                self.left.insert(val)
        elif val > self.val:
            if self.right is None:
                self.right = Node(val, self)
            else:
                self.right.insert(val)

    def search(self, val) -> Optional['Node']:
        if self.val == val:
            return self

        if val < self.val:
            if self.left is None:
                return None

            return self.left.search(val)

        if self.right is None:
            return None

        return self.right.search(val)

    def __height__(self) -> int:
        return 1 + max(height(self.left), height(self.right))

    def is_left(self):
        return self.parent and self.parent.left and self.parent.left.val == self.val

    def is_right(self):
        return self.parent and self.parent.right and self.parent.right.val == self.val

    def balance(self):
        return height(self.left) - height(self.right)

    def print(self):
        lines, _, _, _ = self._print()
        for line in lines:
            print(line)

    def _print(self):
        if self.right is None and self.left is None:
            line = '%s' % self.val
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        if self.right is None:
            lines, n, p, x = self.left._print()
            s = '%s' % self.val
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, n + u // 2

        if self.left is None:
            lines, n, p, x = self.right._print()
            s = '%s' % self.val
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, u // 2

        left, n, p, x = self.left._print()
        right, m, q, y = self.right._print()
        s = '%s' % self.val
        u = len(s)
        first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s + y * '_' + (m - y) * ' '
        second_line = x * ' ' + '/' + (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lines = zip(left, right)
        lines = [first_line, second_line] + [a + u * ' ' + b for a, b in zipped_lines]
        return lines, n + m + u, max(p, q) + 2, n + u // 2
