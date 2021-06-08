package com.example.apptinthethao_java.api;

import com.example.apptinthethao_java.model.CauLacBo;
import com.example.apptinthethao_java.model.CauThu_DoiHinh;
import com.example.apptinthethao_java.model.Cmt;
import com.example.apptinthethao_java.model.DetailPost;
import com.example.apptinthethao_java.model.DienBienTranDau;
import com.example.apptinthethao_java.model.DoiHinh;
import com.example.apptinthethao_java.model.KetQua_TranDau;
import com.example.apptinthethao_java.model.Post;
import com.example.apptinthethao_java.model.Status;
import com.example.apptinthethao_java.model.SuKienTrongTran;
import com.example.apptinthethao_java.model.TranDau;
import com.example.apptinthethao_java.model.User;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SimpleAPI {
    @GET("quan/list_tinmoi")
    Call<ArrayList<Post>> getListTinMoi();

    @GET("quan/list_baiviethot")
    Call<ArrayList<Post>> getListTinNong();

    @GET("quan/list_tinphobien")
    Call<ArrayList<Post>> getListTinPhoBien();

    @GET("quan/list_tinchuyennhuong")
    Call<ArrayList<Post>> getListTinChuyenNhuong();

    @GET("quan/chitietbaiviet/{post_id}")
    Call<ArrayList<DetailPost>> getDetailPost(@Path("post_id") String id);

    @GET("quan/list_clb")
    Call<ArrayList<CauLacBo>> getListCLB();

    @GET("quan/tatcacauthu_clb/{clb_id}")
    Call<ArrayList<CauThu_DoiHinh>> getListCauThu(@Path("clb_id") String id);

    @GET("quan/chitietclb/{clb_id}")
    Call<ArrayList<CauLacBo>> getChiTietCLB(@Path("clb_id") String id);

    @GET("khoa/get_ketqua_nam/{year}")
    Call<ArrayList<KetQua_TranDau>> getListKetQuaTranDau(@Path("year") String year);
//    @GET("khoa/get_ketqua_nam/2021")
//    Call<ArrayList<KetQua_TranDau>> getListKetQuaTranDau();

    @GET("quan/trandau/{match_id}")
    Call<ArrayList<DienBienTranDau>> getTranDau(@Path("match_id") String id);

    @GET("quan/doihinhrasan/{match_id}")
    Call<ArrayList<DoiHinh>> getDoiHinh(@Path("match_id") String id);

    @GET("quan/chitietclb/{clb_id}")
    Call<ArrayList<CauLacBo>> getCLB(@Path("clb_id") String id);

    @GET("quan/trandau_dienbien/{clb_id}")
    Call<ArrayList<SuKienTrongTran>> getSuKienTrongTran(@Path("clb_id") String id);

    @GET("nhan/match_result/{clb_id}")
    Call<ArrayList<TranDau>> getMatchResult(@Path("clb_id") String id);

    @GET("nhan/user/{email}/{password}")
    Call<ArrayList<User>> getLoginResult(@Path("email") String email, @Path("password") String password);

    @GET("khai/getNgaySapDau/{date}")
    Call<ArrayList<Object>> getNgaySapDau(@Path("date") String date);

    @GET("khai/getNgayDaDau/{date}")
    Call<ArrayList<Object>> getNgayDaDau(@Path("date") String date);

    @GET("khai/getTranDau/{date}")
    Call<ArrayList<Object>> getLichTranDau(@Path("date") String date);

    @GET("quan/search/{searchText}")
    Call<ArrayList<Post>> getListPostSearch(@Path("searchText") String searchText);

    @GET("quan/list_comment/{post_id}")
    Call<ArrayList<Cmt>> getListCmt(@Path("post_id") String id);

    @POST("quan/comment")
    Call<Status> postCmt(@Header("account_email") String username, @Header("post_id") String id, @Header("comment_content") String noidung);

    @POST("quan/del/comment")
    Call<Status> deleteCmt(@Header("account_email") String username, @Header("post_id") String id, @Header("comment_time") String noidung);
}
