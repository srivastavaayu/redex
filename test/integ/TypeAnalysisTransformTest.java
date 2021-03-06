/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.redextest;

class Base {
  int getVal() { return 0; }
}

class SubOne extends Base {
  @Override
  int getVal() {
    return 1;
  }
}

class SubTwo extends Base {
  @Override
  int getVal() {
    return 2;
  }
}

class TestRemoveRedundantNullChecks {

  Base mField1;

  TestRemoveRedundantNullChecks() {
    int v = checkEQZInitReachable(mField1);
    v += checkEQZInitReachableGetField();
    mField1 = new Base();
  }

  public Base getSubOne() { return new SubOne(); }

  public Base getSubTwo() { return new SubTwo(); }

  public int checkEQZNullArg(Base b) {
    int i = 0;
    if (b != null) {
      i += b.getVal();
    }
    return i;
  }

  public int checkEQZNotNullArg(Base b) {
    int i = 0;
    if (b != null) {
      i += b.getVal();
    }
    return i;
  }

  public int checkNEZNullArg(Base b) {
    int i = 0;
    if (b == null) {
      i += b.getVal();
    }
    return i;
  }

  public int checkNEZNotNullArg(Base b) {
    int i = 0;
    if (b == null) {
      i += b.getVal();
    }
    return i;
  }

  private int checkEQZInitReachable(Base b) {
    int i = 0;
    if (b != null) {
      i += b.getVal();
    }
    return i;
  }

  private int checkEQZInitReachableGetField() {
    int i = 0;
    if (this.mField1 != null) {
      i += this.mField1.getVal();
    }
    return i;
  }

  static void main() {
    TestRemoveRedundantNullChecks t = new TestRemoveRedundantNullChecks();
    Base b = null;
    t.checkEQZNullArg(b);
    b = new Base();
    t.checkEQZNotNullArg(b);

    b = null;
    t.checkNEZNullArg(b);
    b = new Base();
    t.checkNEZNotNullArg(b);
  }
}
