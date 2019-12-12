The Dummy variable trap is a scenario where there are attributes which are highly correlated (Multicollinear) and one variable predicts the value of others. When we use one hot encoding for handling the categorical data, then one dummy variable (attribute) can be predicted with the help of other dummy variables. Hence, one dummy variable is highly correlated with other dummy variables. Using all dummy variables for regression models lead to dummy variable trap. So, the regression models should be designed excluding one dummy variable.
*Source: GeeksForGeeks*

The intution here is that, you are basicaly duplicating a variable, because in an example of Male and Female catogorical variables labeled as [male=1,female=0], male = 1 - female.
The phenomenon where one or several independent variables in a linear regression predict in another is called multicollinearity.

To sum up:
When ever you are builiding a model always omit one dummy vairable, this applied irrespective of number of dummy variables there are in that specific dummy set.
If you have 9 then only include 8.
If you have mulitple sets of dummy varibales, apply the same rule for each set.

