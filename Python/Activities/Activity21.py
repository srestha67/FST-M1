import pytest


def test_sum():
    assert (2 + 3) == 5
    assert (0 + 0) == 0
    assert (-1 + 1) == 0


def test_difference():
    assert (3 - 2) == 1
    assert (0 - 0) == 0
    assert (-1 - (-1)) == 0


def test_product():
    assert (2 * 3) == 6
    assert (0 * 0) == 0
    assert (-1 * 1) == -1


def test_quotient():
    assert (6 / 3) == 2
    assert (0 / 5) == 0
    assert (-6 / 3) == -2