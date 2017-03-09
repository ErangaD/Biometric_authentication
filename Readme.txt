This system takes the lengths and the widths of fingers and uses those data to 
authenticate users. Length and width are taken using centimeters with a
precision of 4 decimal places. Furthermore, since there can not be lengths and 
widths more than 100cm long, those have been restricted as well. Since the user 
inputs can be slightly changed, Euclidean distance method is used with a 
threshold that can be specified in the GUI (threshold has been initially set to 0.1).
    Since anyone who steals the database file can make a mold and trick the
system, when storing lengths and widths in the database, system uses a cipher.

CIPHER

For all values of lengths and widths, numbers before the decimal point are converted 
to binary and numbers after the decimal point are converted to hexadecimal.
Distance to the decimal point from the beginning is converted to 4 bit octal 
number and append to the appended binary and hexadecimal numbers and are saved in the
database.

Ex: Value = 12.2356
    12 = 1100
    2356 = 934
    decimal point is 4 digits away from the number part (1100) 4 in octal
	Therefore decimal point value will be 0004
    So the saved value in the database will be 11009340004