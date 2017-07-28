package com.shabaton;

import java.io.PrintWriter;

public class Shabaton {

	public static PrintWriter pw;
	
	static {
		try {
			pw = new PrintWriter("C:\\Users\\akova\\workspace\\Shabaton\\src\\com\\shabaton\\output.txt");
		} catch (Exception e) {
			System.out.println("error opening file");
		} finally {
			pw.close();
		}
	}

	public static void main(String[] args) {

		System.out.println("English day of the week is: " + engday_week(2017, 7, 5));

		System.out.println("Molad for year 5777 is : " + molad(5777));
		System.out.println("Molad for year 5778 is : " + molad(5778));
		System.out.println("Molad for year 5779 is : " + molad(5779));

		System.out.println("Classify year for 5777 : " + Shabaton.classify_year(5777));
		System.out.println("Classify year for 5778 : " + Shabaton.classify_year(5778));
		System.out.println("Classify year for 5779 : " + Shabaton.classify_year(5779));
		System.out.println("Classify year for 5780 : " + Shabaton.classify_year(5780));
		System.out.println("Classify year for 5781 : " + Shabaton.classify_year(5781));
		System.out.println("Classify year for 5782 : " + Shabaton.classify_year(5782));
		System.out.println("Classify year for 5783 : " + Shabaton.classify_year(5783));
		System.out.println("Classify year for 5784 : " + Shabaton.classify_year(5784));
		System.out.println("Classify year for 5785 : " + Shabaton.classify_year(5785));
		System.out.println("Classify year for 5786 : " + Shabaton.classify_year(5786));
		System.out.println("Classify year for 5787 : " + Shabaton.classify_year(5787));
		System.out.println("Classify year for 5788 : " + Shabaton.classify_year(5788));
		System.out.println("Classify year for 5789 : " + Shabaton.classify_year(5789));
		System.out.println("Classify year for 5790 : " + Shabaton.classify_year(5790));
		System.out.println("Classify year for 5791 : " + Shabaton.classify_year(5791));
		System.out.println("Classify year for 5792 : " + Shabaton.classify_year(5792));
		System.out.println("Classify year for 5793 : " + Shabaton.classify_year(5793));
		System.out.println("Classify year for 5794 : " + Shabaton.classify_year(5794));
		System.out.println("Classify year for 5795 : " + Shabaton.classify_year(5795));
		
		//convertheb_eng(int HM, int HDT, int HY)
        convertheb_eng(1,1,5777);
        System.out.println("Month: " + EM + " Day: " + EDT + " Year: " + EY);
        
        convert_num_engdate(2017, 1,1,32);

        System.out.println("Year 2017 Day 1 date is : " + EM + " " + EDT + " " + EY);
	}

	public static final int ED[] = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

	/**
	 * 
	 * @param Y
	 *            - year
	 * @param M
	 *            - month
	 * @param D
	 *            - day
	 * @return 0 Saturday 1 Sunday 2 Monday 3 Tuesday 4 Wednesday 5 Thursday 6
	 *         Friday
	 */
	public static int engday_week(int Y, int M, int D) {
		int K;
		int MO;

		K = (int) ((60 + 100 / M) / 100);
		MO = (int) (365 * Y);
		MO = MO + D + (31 * (M - 1));
		MO = MO - (int) (0.4 * M + 2.3) * (1 - K);
		MO = MO + (int) ((Y - K) / 4);
		// MO = MO - (int) 0.75*((int)(Y-K)/100)+1;

		int x = (int) (0.75 * ((int) ((Y - K / 100) + 1)));
		MO = MO - x;
		return MO % 7;

	}
	
	/**
	 * 
	 * @param year  - year according to gregorian calendar
	 * @return  - 1 if it is a leap year; 0 if it is not a leap year
	 */
	public static int isLeapYear(int year) {
		int leapYear = 0; // initially assume it is not a leap year

		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			leapYear = 1;
		}
		
		return leapYear;

	}

	public static int engday_year(int Y, int M, int D) {
		int leapYear = Shabaton.isLeapYear(Y);
		return ED[M - 1] + D + leapYear;
	}

	public static final int HD[][] = { { 0, 30, 59, 88, 117, 147, 176, 176, 206, 235, 265, 294, 324, 353 },
			{ 0, 30, 59, 88, 117, 147, 177, 206, 236, 265, 295, 324, 354, 383 } };

	/**
	 * 
	 * @param L
	 *            - leap year; either 1 for leap year or 0 for not a leap year
	 * @param M
	 *            - hebrew month ; values from 1 to 14
	 * @param HDT
	 *            - ??? not sure what this is ???
	 * @param H1
	 *            - ??? not sure what this is ???
	 * @param H2
	 *            - ??? not sure what this is
	 * @return
	 */
	public static int hebday_year(int L, int M, int HDT, int H1, int H2) {
		// I don't understand the logic in this function need to figure it out

		if (M > 3) {
			return HD[L][M - 1] + HDT + H1 + H2;
		}

		if (M < 3) {
			return HD[L][M - 1] + HDT;
		}

		return HD[L][M - 1] + HDT + H1;
	}

	// ?? not sure what this is
	public static final int[] TM = { 222, 0, 12, 24, 37, 49, 61, 74, 86, 99, 111, 123, 136, 148, 160, 173, 185, 197,
			210 };

	// astronomical numbers for calculating new moon
	public static final double MB = 2.216203704;
	public static final double MF = 1.530594136;

	/**
	 * Calculates the molad day of the week for rosh hashana for a given hebrew
	 * year
	 * 
	 * @param year
	 *            - hebrew year
	 * @return
	 */
	public static double molad(int hebrewYear) {
		// n is cycle number and c is the year in that cycle
		int n;
		int c;

		n = (int) hebrewYear / 19;
		c = hebrewYear % 19;

		if (c == 0) {
			n--;
		}

		double x = MB + (235 * n + TM[c]) * MF;
		double y = 7.0;

		return x % y;
	}

	public static int classify_year(int hyear) {

		// Calculates which year of the 19 year cycle is hyear.
		// If this year is the 0,3,6,8,11,14,17 year then it is a leap year
		// and l is set to 1. Otherwise l is set to 0;
		int c;
		// l is set to 1 if hyear is a leap year; otherwise it is set to 0
		int l;

		// mol holds the molad of rosh hashana at the start and end of the year
		double mol[] = new double[2];

		// d contains the day of the week of the molad
		int d[] = new int[2];

		c = hyear % 19;

		mol[0] = Shabaton.molad(hyear);
		mol[1] = Shabaton.molad(hyear + 1);
		d[0] = (int) mol[0];
		d[1] = (int) mol[1];
		pw.println("mol[0] is: " + mol[0] + "    " + "mol[1] is: " + mol[1]);
		pw.println("d[0] is: " + d[0] + "    " + "d[1] is: " + d[1]);

		/**
		 * At this point we have the date on which the molads fall out. However
		 * we now must check if the year has rosh hashana on the day of the
		 * molad or if r"h is pushed off one day. There are four rules for
		 * pushing r"h one day forward. RULE 1: if the modlad is after noon.
		 * RULE 2: if r"h would fall out on sunday, wednesday, friday (the
		 * latter two would cause yom kippur to fall out on Fri or Sun) RULE 3:
		 * if molad falls on Tuesday after 11 min 20 seconds after 3 A.M. then
		 * r"h is pushed off to Thursday since Wednesday would violate rule 1
		 * RULE 4: after a leap year if molad falls out on Monday after 32 min
		 * 43 and 1/3 seconds after 9 AM.
		 */
		for (int i = 0; i < 2; i++) {
			l = mult_or(c);
			// rule 1
			if ((double) (mol[i] - d[i]) >= (double) 0.75) {
				d[i] = (d[i] + 1) % 7;

				// rule 2
				if (d[i] == 1 || d[i] == 4 || d[i] == 6) {
					d[i] = (d[i] + 1) % 7;
				}
			} else if (d[i] == 1 || d[i] == 4 || d[i] == 6) { // rule 2
				d[i] = (d[i] + 1) % 7;
			} else if (l == 0 && d[i] == 3 && mol[i] >= 3.38287037) { // rule 3
				d[i] = 5;
			} else if (d[i] == 2 && Shabaton.mult_or(c + 1) == 1 && mol[i] >= 2.647723765) { // rule
																								// 4
				d[i] = 3;
			}
			c = (c + 1) % 19;
		}

		c = (c - 2) % 19;
		l = Shabaton.mult_or(c);
		int resultValue = 0;
		switch (d[0]) {
		case 0:
			switch (d[1]) {
			case 0:
				resultValue = 13;
				break;
			case 3:
				resultValue = 7;
				break;
			case 5:
				resultValue = (l == 1 ? 14 : 6);
				break;
			default:
				resultValue = 0;
				break;
			}
			break;
		case 2:
			switch (d[1]) {
			case 0:
				resultValue = (l == 1 ? 9 : 1);
				break;
			case 2:
				resultValue = 8;
				break;
			case 5:
				resultValue = 2;
				break;
			default:
				resultValue = 0;
				break;
			}
			break;
		case 3:
			switch (d[1]) {
			case 0:
				resultValue = 3;
				break;
			case 2:
				resultValue = 10;
				break;
			default:
				resultValue = 0;
				break;
			}
			break;
		case 5:
			switch (d[1]) {
			case 2:
				resultValue = 5;
				break;
			case 3:
				resultValue = (l == 1 ? 12 : 4);
				break;
			case 5:
				resultValue = 11;
				break;
			default:
				resultValue = 0;
				break;
			}
			break;
		default:
			resultValue = 0;
		}
		return resultValue;

	}

	/**
	 * 
	 * @param yearOfHebrewCycle
	 * @return 0 if not leap year; 1 if leap year
	 */
	public static int mult_or(int yearOfHebrewCycle) {
		int c = yearOfHebrewCycle;
		int leapYear = 0;
		if (c == 0 || c == 3 || c == 6 || c == 8 || c == 11 || c == 14 || c == 17) {
			leapYear = 1;
		}
		return leapYear;
	}

	public static int HK, HW;
	public static int RD, RM;  // Rosh hashana day and month
	public static int Y, M, DT;  // year, month, day
	public static int D1, D2;
	public static int H1, H2;
	public static int HT;
	public static int EW, EL, ET, EY, EM, EDT;
	public static int F;
	public static final int K[] = { 11, 8, 13, 23, 21, 3, 0, 11, 8, 13, 23, 20, 3, 0 };
	public static final int R[] = { 14, 3, 22, 12, 30, 18, 8, 26, 15, 4, 24, 12, 1, 20, 10, 28, 17, 6, 26 };

	/**
	 * 
	 * @param HM - hebrew month
	 * @param HDT - hebrew day of month
	 * @param HY - hebrew year
	 * 
	 * sets the variables EM, EDT, EY  
	 *  convertheb_eng(1,1,5777);   input date is Thishrei 1, 5777  ; output-  sets EM to 10, EDT to 2, EY to 2016 
	 */
	public static void convertheb_eng(int HM, int HDT, int HY) {
		int flag;
		EY = HY - 3761;
		Y = HY;
		HK = Shabaton.classify_year(HY);
		HW = (int) (K[HK - 1] / 4);
		RD = R[HY % 19];
		RM = (RD > 5) ? 9 : 10;
		M = RM;
		DT = RD;
		Y = EY;
		EW = engday_week(Y,M,DT);
		
		if ((HW - EW) > 3) {
			HW = HW - 7;
		}
		
		if ((HW - EW) < -3) {
			HW = HW + 7;
		}
		
		RD = RD + HW - EW;
		
		// If Rosh hashana falls out after the 30th it must be in October
		if (RD > 30) {
			RD = RD - 30;
			RM = 10;
		}
		
		// If Rosh Hashana falls out before the 1st it must be in September
		if (RD < 1) {
			RD = RD + 30;
			RM = 9;
		}
		
		D1 = engday_year(EY, RM, RD);
		H1 = K[HK-1] & 3;
		H2 = H1 & 1;
		H1 = H1 >> 1;
		
		int i = HY % 19;
		flag = Shabaton.mult_or(i);
		D2 = hebday_year (flag,HM, HDT, H1, H2);
		HT = D1 + D2;
		EL = (Shabaton.isLeapYear(Y) == 1 ) ? 366 : 365;
		
		if (HT > EL) {
		   if (HT > EL) {
			   HT = HT - EL;
			   EY++;
		   }
		}
		
		for (EM = 1, F=HT-3; EM<=12 && HT >=(F+2); EM++) {
			F = Shabaton.engday_year(EY,EM+1,0);
		}
		F = Shabaton.engday_year(EY, --EM, 0);
		EDT = HT-F-1;
		if (EM==1 && EDT==0) {
			EM=12;
			EY--;			
		}
		
	}
	
	/**
	 * 
	 * @param _EY english gregorian year
	 * @param _EM english gregorian month
	 * @param _EDT english gregorian day of month
	 * @param HT converts this number into and english gregorian date
	 * sets the following variables EY - year
	 *  							EM - month
	 *  							EDT - day of month
	 */
	public static void convert_num_engdate(int _EY, int _EM, int _EDT, int HT) {
		
		int EL = ( Shabaton.isLeapYear(_EY) == 1 ? 366 : 365 ); 
		if (HT > EL) {
			HT = HT - EL;
			_EY++;
		}
		
		for (_EM = 1, F=HT-3; _EM <= 12 && HT >= (F+1); _EM++) {
			F = engday_year(_EY, _EM+1, 0);
		}
		F = engday_year(_EY, --_EM, 0);
		_EDT = HT-F;
		if (_EM == 1 && _EDT == 0 ) {
			_EM--;
		}
		
		EY = _EY;
		EM = _EM;
		EDT = _EDT;
	}
	
	public static int YB, HY;
	public static int HE, HM, HDT;
	
	public static void convert_eng_heb (int EM, int EDT, int EY) {
		int flag;
		YB = 0;
		
		// HY is Hebrew year if date is after rosh hashana of that year
		
		HY = EY + 3761;
		flag = 1;
		while (flag == 1) {
			HK = classify_year(HY);
			HW = K[HK-1] / 4;
			RD = R[HY%19];
			RM = (RD > 5) ? 9 : 10;
			M = RM;
			DT = RD;
			Y = EY - YB;
			EW = engday_week(Y,M,DT);
			if (HW - EW > 3) {
				HW = HW - 7;
			}
			if (HW - EW < -3) {
				HW = HW + 7;
			}
			RD = RD + HW - EW;
			// if Rosh Hashana falls out after the 30th it must be in October
			if (RD > 30) {
				RD = RD - 30;
				RM = 10;
			}
			// if Rosh Hashana falls out before the 1st it must be in September
			if (RD < 1) {
				RD = RD + 30;
				RM = 9;
			}
			if (YB == 0 && (EM < RM || (EM == RM && EDT < RD))) {
				YB = 1;
				HY = EY + 3760;
			} else {
				flag = 0;
			}
		}
		D1 = Shabaton.engday_year((EY-YB), RM,RD);
		D2 = Shabaton.engday_year(EY,EM,EDT);
		Y = EY-YB;
		EL = (Shabaton.isLeapYear(Y) == 1) ? 366 : 365;
		ET = D2 - D1;
		if (YB == 1) {
			ET = ET + EL;
		}
		// H1 is bit 1 ; H2 is bit 0 of K(HK)
		H1 = K[HK-1] & 3;
		H2 = H1 & 1;
		H1 = H1 >> 1;
		flag = HY % 19;
		HE = 12 + Shabaton.mult_or(flag);
		
		for ( HM = 1, HDT =0; (HM<=13) && HDT >= 0; HM++ ) {
			if ( (HE & 1) != 0 || HM != 7) {
				M = HM+1;
				HDT = ET - hebday_year((HE&1),M,0,H1,H2);
			}
		}
		M = M - HM;
		HDT = ET - hebday_year((HE&1), M,0,H1,HT) + 1;
		flag = HY%19;
		flag = Shabaton.mult_or(flag);
		D2= Shabaton.hebday_year(flag, HM, HDT, H1, H2);
	}
	
}
