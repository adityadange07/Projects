#include<iostream>

using namespace std;

string rollno[20], name[20], course[20], stnd[20], contact[20];

int total = 0;

void enterData()
{
	int ch = 0;
	cout<<"How many students do you want to enter?"<<endl;
	cin>>ch;
	if(total==0)
	{
		total = ch + total;

		for(int i = 0; i < ch; i++)
		{
			cout<<"\nEnter the Data of Student "<<i + 1<<endl;

			cout<<"Enter Roll No : ";

			cin>>rollno[i];

			cout<<"Enter Name : ";

			cin>>name[i];

			cout<<"Enter Course : ";

			cin>>course[i];

			cout<<"Enter Class : ";

			cin>>stnd[i];

			cout<<"Enter Contact : ";

			cin>>contact[i];
		}
	}

	else

	{
		for(int i = total; i < ch; i++)
		{
			cout<<"\nEnter the Data of student "<<i+1<<endl<<endl;

			cout<<"Enter Roll No : ";

			cin>>rollno[i];

			cout<<"Enter Name : ";

			cin>>name[i];

			cout<<"Enter Course : ";

			cin>>course[i];

			cout<<"Enter Class : ";

			cin>>stnd[i];

			cout<<"Enter Contact : ";

			cin>>contact[i];
		}
		total=ch+total;
	}
}

void showData()
{
	if(total==0)
	{
		cout<<"opps.. No data found"<<endl;
	}
	else
	{
		for(int i=0;i<total;i++)
	    {
    		cout<<"\nData of Student "<<i+1<<endl<<endl;

    		cout<<"Roll No : "<<rollno[i]<<endl;

    		cout<<"Name : "<<name[i]<<endl;

    		cout<<"Course : "<<course[i]<<endl;

	    	cout<<"Class : "<<stnd[i]<<endl;

	    	cout<<"Contact : "<<contact[i]<<endl;
	    }
	}
}

void searchData()
{
	if(total==0)
	{
		cout<<"opps.. No data found"<<endl;
	}

	else

	{
		string rollno;

		cout<<"Enter the Roll No of Student"<<endl;

		cin>>rollno;

		for(int i=0;i<total;i++)
		{
			if(rollno==rollno[i])
			{
				cout<<"Roll No : "<<rollno[i]<<endl;

				cout<<"Name : "<<name[i]<<endl;

	            cout<<"Course : "<<course[i]<<endl;

	            cout<<"Class : "<<stnd[i]<<endl;

	           	cout<<"Contact : "<<contact[i]<<endl;
			}

		}

	}
}

void updateData()
{
	if(total==0)
	{
		cout<<"opps.. No data found"<<endl;

	}
	else
	{
		string rollno;

		cout<<"Enter the roll no of student which you want to update"<<endl;

		cin>>rollno;

		for(int i=0;i<total;i++)
		{
			if(rollno==arr2[i])
			{
				cout<<"\nPrevious data"<<endl<<endl;

				cout<<"Data of Student "<<i+1<<endl;

				cout<<"Roll No : "<<rollno[i]<<endl;

				cout<<"Name : "<<name[i]<<endl;

	            cout<<"Course : "<<course[i]<<endl;

	            cout<<"Class : "<<stnd[i]<<endl;

	           	cout<<"Contact : "<<contact[i]<<endl;

	           	cout<<"\nEnter new data"<<endl<<endl;

	       		cout<<"Enter Roll No : ";

		        cin>>rollno[i];

				cout<<"Enter Name : ";

		        cin>>name[i];

		       	cout<<"Enter Course : ";

		        cin>>course[i];

		        cout<<"Enter Class : ";

		        cin>>stnd[i];

		        cout<<"Enter Contact : ";

		        cin>>contact[i];
			}

		}
	}

}

void deleteData()
{
	  if(total==0)
	{
		cout<<"opps.. No data found"<<endl;
	}
	else
	{
		int a;

	    cout<<"Press 1 to delete all record"<<endl;

		cout<<"Press 2 to delete specific record"<<endl;

		cin>>a;

		if(a==1)
		{
			total=0;

			cout<<"All record is deleted..!!"<<endl;
		}

		else if(a==2)
		{
			string rollno;

			cout<<"Enter the Roll No of student which you wanted to delete"<<endl;

			cin>>rollno;

			for(int i=0;i<total;i++)

			{

				if(rollno==arr2[i])

				{

					for(int j=i;j<total;j++)

					{

						rollno[j]=rollno[j+1];

						name[j]=name[j+1];

				    	course[j]=course[j+1];

						stnd[j]=stnd[j+1];

						contact[j]=contact[j+1];

			     	}

					total--;

					cout<<"Your required record is deleted"<<endl;

					}

				}

			}
			else
			{
				cout<<"Invalid input";

			}
	}
}

main()
{
	int option;

	while(true)
	{
		cout<<"Press 1 : Enter Data"<<endl;
		cout<<"Press 2 : Show Data"<<endl;
		cout<<"Press 3 : Search Data"<<endl;
		cout<<"Press 4 : Update Data"<<endl;
		cout<<"Press 5 : Delete Data"<<endl;
		cout<<"Press 6 : Exit"<<endl;
		Cin>>value;

		switch(option)
		{
			case 1:
				enterData();
				break;
			case 2:
				showData();
				break;
			case 3:
				searchData();
				break;
			case 4:
				updateData();
				break;
			Case 5:
				deleteData();
				break;
			case 6:
				exit(0);
			default():
				cout<<"Invalid input!!"<<endl;
		}
	}
}
