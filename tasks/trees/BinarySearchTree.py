from typing import Optional
from tasks.trees.Node import Node, height


class BinarySearchTree:
    root: Optional[Node]

    def __init__(self, root: Optional[Node] = None):
        self.root = root

    def insert(self, val: int):
        if self.root is None:
            self.root = Node(val)
            return

        return self.root.insert(val)

    def search(self, val):
        if self.root:
            return self.root.search(val)

    def height(self):
        if self.root:
            return height(self.root)

    def print(self):
        if self.root:
            self.root.print()

    def remove(self, val):
        node = val
        if type(val) is int:
            node = self.search(val)

        if node is None:
            return

        node_parent = node.parent

        if node.left is None and node.right is None:
            if node.is_left():
                node_parent.left = None
            elif node.is_right():
                node_parent.right = None

        if node.left and node.right:
            temp = node
            while temp.left:
                temp = temp.left

            node.val = temp.val
            self.remove(temp)

        if node.left or node.right:
            child = node.left or node.right

            if node.is_left():
                node_parent.left = child
            elif node.is_right():
                node_parent.right = child
            else:
                self.root = child

            child.parent = node_parent

