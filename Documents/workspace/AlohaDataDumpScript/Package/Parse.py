import csv
import re
# open Write file
#newline='' --< goes in last parameter of first open()
with open('formattedGCData.csv', 'wt',newline='') as writefile:
   writer = csv.writer(writefile, 'excel')
   # open Read file
  # encoding = 'UTF8' --> last parameter in open()
  #use exact path when passing in file to read from. / // // 
   with open("/Users/acoomber/SimmsDataDump3.csv", 'rt', encoding='UTF8') as cardfile:
       reader = csv.reader(cardfile)
       read_row = next(reader)
       line_count = 0
       store_code = 0
       date = '00/00/00'
       cardnum = ''
       card_count = 0

       writer.writerow(['Card Number', 'Store Code', 'Enroll Date', 'Amount'])

       # loop through lines in readfile
       for read_row in reader:
           row_count = 0

           # get store code
           if (read_row[0] != ''):
               store_code = read_row[0]
               #store code = numbers extracted from read_row[0]
               #store_code=filter(str.isdigit, store_code)
               store_code= re.findall(r"[-+]?\d*\.\d+|\d+", store_code)
               #store_code= re.findall("\d+\.\d+", store_code)

               # get numbers in string= store code
               # store code = return value of function isNumeric()
               # isNumeric() returns a string of numbers that is store_code

           ##store_code = store_code[0:3]

           # get date
           if (read_row[1] != ''):
               date = read_row[1]

           # get card num
           if (len(read_row[3]) > 10):
               cardnum = read_row[3]
               print('cardnum: ', cardnum)
               writer.writerow([cardnum, store_code, date, read_row[5]])
               card_count += 1

           line_count += 1

       print('total cards: ', card_count)
       print('total lines: ', line_count)
