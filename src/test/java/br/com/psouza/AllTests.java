package br.com.psouza;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProductTest.class, SaleTest.class, ClientTest.class})
public class AllTests {
}
