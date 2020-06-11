from tester import Tester

from tasks.string import task as string_task
from tasks.tickets import task as tickets_task
from tasks.GCD import remainder as gcd_task_remainder, binary as gcd_task_binary
from tasks.power import task as power_task
from tasks.fibo import iterative as fibo_task_iterative, matrix as fibo_task_matrix
from tasks.king import task as king_task
from tasks.knight import task as knight_task
from tasks.FEN import task as fen_task
from tasks.sort import selection as sort_task_selection,\
    insertion as sort_task_insertion, shell as sort_task_shell, heap as sort_task_heap


print('string task')
Tester(string_task, './tests/0.string').check_all()
print()

print('tickets task')
Tester(tickets_task, './tests/1.tickets').check_all()
print()

print('gcd task: remainder')
Tester(gcd_task_remainder, './tests/2.GCD').check_all()
print()

print('gcd task: binary')
Tester(gcd_task_binary, './tests/2.GCD').check_all()
print()

print('power task')
Tester(power_task, './tests/3.power').check_all()
print()

print('fibo task: iterative')
Tester(fibo_task_iterative, './tests/4.fibo').check_all()
print()

print('fibo task: matrix')
Tester(fibo_task_matrix, './tests/4.fibo').check_all()
print()

print('king task')
Tester(king_task, './tests/6.king').check_all()
print()

print('knight task')
Tester(knight_task, './tests/7.knight').check_all()
print()

print('FEN task')
Tester(fen_task, './tests/8.FEN').check_all()
print()

print('sort task: selection -- RANDOM')
Tester(sort_task_selection, './tests/9.sort/0.random').check_all()
print()

print('sort task: selection -- DIGITS')
Tester(sort_task_selection, './tests/9.sort/1.digits').check_all()
print()

print('sort task: selection -- SORTED')
Tester(sort_task_selection, './tests/9.sort/2.sorted').check_all()
print()

print('sort task: selection -- REVERS')
Tester(sort_task_selection, './tests/9.sort/3.revers').check_all()
print()

print('sort task: insertion -- RANDOM')
Tester(sort_task_insertion, './tests/9.sort/0.random').check_all()
print()

print('sort task: insertion -- DIGITS')
Tester(sort_task_insertion, './tests/9.sort/1.digits').check_all()
print()

print('sort task: insertion -- SORTED')
Tester(sort_task_insertion, './tests/9.sort/2.sorted').check_all()
print()

print('sort task: insertion -- REVERS')
Tester(sort_task_insertion, './tests/9.sort/3.revers').check_all()
print()

print('sort task: shell -- RANDOM')
Tester(sort_task_shell, './tests/9.sort/0.random').check_all()
print()

print('sort task: shell -- DIGITS')
Tester(sort_task_shell, './tests/9.sort/1.digits').check_all()
print()

print('sort task: shell -- SORTED')
Tester(sort_task_shell, './tests/9.sort/2.sorted').check_all()
print()

print('sort task: shell -- REVERS')
Tester(sort_task_shell, './tests/9.sort/3.revers').check_all()
print()

print('sort task: heap -- RANDOM')
Tester(sort_task_heap, './tests/9.sort/0.random').check_all()
print()

print('sort task: heap -- DIGITS')
Tester(sort_task_heap, './tests/9.sort/1.digits').check_all()
print()

print('sort task: heap -- SORTED')
Tester(sort_task_heap, './tests/9.sort/2.sorted').check_all()
print()

print('sort task: heap -- REVERS')
Tester(sort_task_heap, './tests/9.sort/3.revers').check_all()
print()
