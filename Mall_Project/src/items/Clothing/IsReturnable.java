package items.Clothing;

import java.time.LocalDate;

public interface IsReturnable {

	boolean isReturnable(LocalDate soldDate);
}
