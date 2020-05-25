package com.project.platooning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.platooning.R;
import com.project.platooning.item.Carnum;

import java.util.ArrayList;

public class Link_List_Adpater extends RecyclerView.Adapter<Link_List_Adpater.ViewHolder>{
    Context mContext;
    int row_res_id;
    ArrayList<Carnum> carlist;

    public Link_List_Adpater(Context mContext, int row_res_id, ArrayList<Carnum> carlist){
        this.mContext = mContext;
        this.row_res_id = row_res_id;
        this.carlist = carlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(row_res_id,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView carnum_bluetooth = holder.carnum_bluetooth;
        carnum_bluetooth.setText(carlist.get(position).getCarnum());
    }

    @Override
    public int getItemCount() {
        return carlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView carnum_bluetooth;
        Button blue_connect;
        private static final boolean D = true;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carnum_bluetooth = itemView.findViewById(R.id.carnum_item);

            //2. 블루투스 연결(페어링) - 연결해야하는 기기가 여러 대 이므로 ArrayList에 저장
            blue_connect = itemView.findViewById(R.id.blue_connect);
            blue_connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //여기에 통신 관련 메소드 뿌리기
                    //통신이 완료되면 연결되었습니다 토스트 메세지
                    Toast.makeText(mContext,"연결이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                    //또 다른 자동차 연결 클릭
                }
            });
        }
    }
}
