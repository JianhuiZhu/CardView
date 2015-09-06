# CardView
        This is a card view EXAMPLE just for learning and fun^_^
![alt tag](https://github.com/JianhuiZhu/CardView-Example/blob/master/example.gif)
        All file included. Just compile and go.
        All code with related comments.
        Have fun
#Library
        compile 'com.android.support:recyclerview-v7:22.2.0'
        compile 'com.android.support:cardview-v7:22.2.0'
        compile 'com.jakewharton:butterknife:7.0.1'
        compile 'com.squareup.picasso:picasso:2.5.2'

#XML layout file
###activity_main
        <FrameLayout
            android:layout_height="match_parent"
            xmlns:android="http://schemas.android.com/apk/res/android"
            android:layout_width="match_parent"
            xmlns:tools="http://schemas.android.com/tools">

            <android.support.v7.widget.RecyclerView
                android:id="@+id/list"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".MyActivity" />

        </FrameLayout>
###card_view
        <?xml version="1.0" encoding="utf-8"?>
        <android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:card_view="http://schemas.android.com/apk/res-auto"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_margin="5dp"
            android:orientation="horizontal"
            card_view:cardBackgroundColor="@color/cardview_dark_background"
            card_view:cardCornerRadius="5dp">

            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="200dp">

                <ImageView
                    android:id="@+id/image_for_card"
                    android:layout_width="match_parent"
                    android:layout_height="200dp" />

                <TextView
                    android:id="@+id/card_name"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginBottom="10dp"
                    android:clickable="true"
                    android:gravity="end|bottom"
                    android:textColor="@android:color/white"
                    android:textSize="36sp"
                    android:textStyle="italic" />

            </RelativeLayout>
        </android.support.v7.widget.CardView>