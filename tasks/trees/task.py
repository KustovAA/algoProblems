from tasks.trees.BinarySearchTree import BinarySearchTree
from tasks.trees.AVLTree import AVLTree


def task(inner):
    def outer(data):
        if len(data) < 1:
            return None

        inner(data[0].split())

        return 'PASSED'

    return outer


@task
def bst_tree(nums):
    bst = BinarySearchTree()
    for i in nums:
        num = int(i)
        bst.insert(num)

    for i in range(len(nums) - 1, len(nums) - len(nums) // 10, -1):
        num = int(nums[i])
        bst.search(num)

    for i in range(len(nums) - 1, len(nums) - len(nums) // 10, -1):
        num = int(nums[i])
        bst.remove(num)


@task
def avl_tree(nums):
    avl = AVLTree()
    for i in nums:
        num = int(i)
        avl.insert(num)

    for i in range(len(nums) - 1, len(nums) - len(nums) // 10, -1):
        num = int(nums[i])
        avl.search(num)

    for i in range(len(nums) - 1, len(nums) - len(nums) // 10, -1):
        num = int(nums[i])
        avl.remove(num)
